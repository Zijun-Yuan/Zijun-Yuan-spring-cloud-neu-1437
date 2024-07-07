package com.b430.userservice.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.b430.commonmodule.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/user")
public class UserController {
    @Value("${config.redisTimeout}")
    private Long redisTimeout;

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/login")
    public String login() {
        String token = JwtUtil.getToken("123", "role", "role-issuer");
        // 将token存入redis中，并设置超时时间
        redisTemplate.opsForValue().set(token, token, redisTimeout, TimeUnit.SECONDS);
        // 然后返回token
        return token;
    }

    @GetMapping("/test/hotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "testHotKeyHandler")
    public String hotKey(@RequestParam(value = "key", required = false) String key, @RequestParam(value = "value", required = false) String value) {

        return "testHotKey";
    }

    // 降级方法,自定义降级逻辑与返回值
    public String testHotKeyHandler(String key, String value, BlockException ex) {
        return "testHotKey,触发了降级的方法.";
    }

}
