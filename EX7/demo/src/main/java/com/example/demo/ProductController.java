package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository repo;

    // GET all
    @GetMapping
    public List<Product> getAll() {
        return repo.findAll();
    }

    // Custom query 1 — expensive products
    @GetMapping("/expensive")
    public List<Product> expensive(@RequestParam Double minPrice) {
        return repo.findExpensiveProducts(minPrice);
    }

    // Custom query 2 — search by keyword
    @GetMapping("/search")
    public List<Product> search(@RequestParam String keyword) {
        return repo.findByKeyword(keyword);
    }
}