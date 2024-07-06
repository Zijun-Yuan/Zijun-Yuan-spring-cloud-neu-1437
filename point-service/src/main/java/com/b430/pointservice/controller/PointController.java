package com.b430.pointservice.controller;

import com.b430.commonmodule.entity.Order;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/point")
public class PointController {
    @GetMapping("/test")
    public String test() {
        return "Test Point Service";
    }

    @PostMapping("/add")
    public String addPoint(@RequestBody Order order) {
        return "333333" + order.getOrderName();
    }

    @PostMapping("/add2")
    public String addPoint2(@RequestParam("orderName") String orderName) {
        return "Add Point Successfully,商品名称" + orderName;
    }
}
