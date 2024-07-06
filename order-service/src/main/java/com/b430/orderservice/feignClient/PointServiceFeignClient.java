package com.b430.orderservice.feignClient;

import com.b430.commonmodule.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "point-service")
public interface PointServiceFeignClient {
    @PostMapping(value = "/point/add")
    String addPoint(@RequestBody Order order);

    @PostMapping(value = "/point/add2")
    String addPoint2(@RequestParam("orderName") String orderName);

}
