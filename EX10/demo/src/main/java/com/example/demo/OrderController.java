package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @GetMapping("/place")
    public String place(@RequestParam String product) {
        return service.placeOrder(product);
    }

    @GetMapping("/cancel")
    public String cancel(@RequestParam String product) {
        return service.cancelOrder(product);
    }
}