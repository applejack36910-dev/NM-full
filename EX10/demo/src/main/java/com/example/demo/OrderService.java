package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class OrderService {

    public String placeOrder(String product) {
        return "Order placed for: " + product;
    }

    public String cancelOrder(String product) {
        return "Order cancelled for: " + product;
    }
}