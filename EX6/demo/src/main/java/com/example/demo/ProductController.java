package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository repo;

    // GET all products
    @GetMapping
    public List<Product> getAll() {
        return repo.findAll();
    }

    // UPDATE a product by id
    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product updated) {
        Product existing = repo.findById(id).orElseThrow();
        existing.setName(updated.getName());
        existing.setPrice(updated.getPrice());
        existing.setCategory(updated.getCategory());
        return repo.save(existing);
    }
}