package com.b430.commonmodule.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {
    // 用于签名加密的密钥，为一个字符串（需严格保密）
    private static final String KEY = "token_key";

    public static final int TOKEN_TIME_OUT = 1000 * 60 * 60 * 24; // 1 day expiration

    public static String getToken(String userId, String role, String issuer) {
        // 获取jwt生成器
        JWTCreator.Builder jwtBuilder = JWT.create();

        // 由于该生成器设置Header的参数为一个<String, Object>的Map,
        // 所以我们提前准备好
        Map<String, Object> headers = new HashMap<>();
        headers.put("typ", "jwt");   // 设置token的type为jwt
        headers.put("alg", "hs256"); // 表明加密的算法为HS256

        // 开始生成token
        // 我们将之前准备好的header设置进去
        String token = jwtBuilder.withHeader(headers)
                // 设置用户id
                .withClaim("userId", userId)
                // 设置用户角色
                .withClaim("role", role)
                // token失效时间
                .withExpiresAt(new Date(System.currentTimeMillis() + TOKEN_TIME_OUT))
                // 设置该jwt的发行时间，一般为当前系统时间
                .withIssuedAt(new Date(System.currentTimeMillis()))
                // token的发行者
                .withIssuer(issuer)
                // 进行签名，选择加密算法，以一个字符串密钥为参数
                .sign(Algorithm.HMAC256(KEY));

        return token;
    }

    public static boolean verify(String token) {
        if (token == null) return false;

        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(KEY)).build();
        DecodedJWT decodedJWT;

        try {
            decodedJWT = verifier.verify(token);
        } catch (Exception e) {
            return false;
        }

        Map<String, Claim> claims = decodedJWT.getClaims();
        if (claims == null) return false;
        if (claims.get("userId") == null) return false;
        if (claims.get("role") == null) return false;

        return true;
    }

    public static String getUserIdFromToken(String token) {
        return JWT.decode(token).getClaim("userId").asString();
    }

    public static String getRoleFromToken(String token) {
        return JWT.decode(token).getClaim("role").asString();
    }
}
