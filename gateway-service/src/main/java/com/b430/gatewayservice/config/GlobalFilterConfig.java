package com.b430.gatewayservice.config;

import com.b430.commonmodule.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class GlobalFilterConfig implements GlobalFilter {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();

        String path = request.getURI().getPath();
        if (path.startsWith("/api/admin/task/login") || path.startsWith("/api/supervisor/login")
                || path.startsWith("/api/supervisor/register") || path.startsWith("/api/inspector/login")
                || path.startsWith("/api/dataScreen") || path.startsWith("/api/location")) {
            return chain.filter(exchange);
        }

        String token = request.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
        if (token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
            System.out.println("Token not found or invalid format");
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();
        }

        token = token.replace("Bearer ", "").trim();

        try {
            boolean isValid = JwtUtil.verify(token);
            if (!isValid) {
                throw new RuntimeException("Token verification failed");
            }
        } catch (Exception e) {
            System.out.println("Token not valid (try catch): " + e.getMessage());
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();
        }

        String userId;
        String role;
        try {
            userId = JwtUtil.getUserIdFromToken(token);
            role = JwtUtil.getRoleFromToken(token);
        } catch (Exception e) {
            System.out.println("Token not valid (try catch): " + e.getMessage());
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();
        }

        String redisKey = role + ":" + userId;
        String redisToken = redisTemplate.opsForValue().get(redisKey);
        if (redisToken == null || !redisToken.equals(token)) {
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            System.out.println("Token not valid");
            return response.setComplete();
        }

        if (!isAuthorizedPath(path, role)) {
            response.setStatusCode(HttpStatus.FORBIDDEN);
            return response.setComplete();
        }

        return chain.filter(exchange);
    }

    private boolean isAuthorizedPath(String path, String role) {
        switch (role) {
            case "Admin":
                return path.startsWith("/api/admin");
            case "Supervisor":
                return path.startsWith("/api/supervisor");
            case "Inspector":
                return path.startsWith("/api/inspector");
            default:
                return false;
        }
    }
}
