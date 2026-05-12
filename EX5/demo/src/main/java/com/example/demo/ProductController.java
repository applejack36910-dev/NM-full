package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository repo;

    @GetMapping("/category/{category}")
    public List<Product> byCategory(@PathVariable String category) {
        return repo.findByCategory(category);
    }

    @GetMapping("/search")
    public List<Product> search(@RequestParam String keyword) {
        return repo.findByNameContaining(keyword);
    }

    @GetMapping("/price/under")
    public List<Product> underPrice(@RequestParam Double max) {
        return repo.findByPriceLessThan(max);
    }

    @GetMapping("/price/above")
    public List<Product> abovePrice(@RequestParam Double min) {
        return repo.findByPriceGreaterThan(min);
    }
}