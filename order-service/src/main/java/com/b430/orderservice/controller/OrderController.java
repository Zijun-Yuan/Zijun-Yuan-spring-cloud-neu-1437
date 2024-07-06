package com.b430.orderservice.controller;

import com.b430.commonmodule.entity.Order;
import com.b430.orderservice.feignClient.PointServiceFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@RefreshScope
public class OrderController {
    @Value("${config.info}")
    private String configInfo;

    @Autowired
    private PointServiceFeignClient pointServiceFeignClient;

    @GetMapping(value = "/test")
    public String test() {
        return "Hello, World!";
    }

    @GetMapping(value = "/test/getConfigInfo")
    public String getConfigInfo() {
        return configInfo;
    }

    @PostMapping(value = "/add")
    public String addOrder() {
        Order order = new Order();
        order.setOrderId("123456");
        order.setOrderName("Test Order");
        String result = pointServiceFeignClient.addPoint(order);
        return result;
    }

    @PostMapping(value = "/add2")
    public String addOrder2() {
        String result = pointServiceFeignClient.addPoint2("这是一个商品名2");
        return result;
    }

}
