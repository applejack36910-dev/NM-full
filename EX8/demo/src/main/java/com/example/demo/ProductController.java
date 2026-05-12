package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository repo;

    // CREATE
    @PostMapping
    public Product create(@RequestBody Product product) {
        return repo.save(product);
    }

    // READ ALL
    @GetMapping
    public List<Product> getAll() {
        return repo.findAll();
    }

    // READ ONE
    @GetMapping("/{id}")
    public Product getOne(@PathVariable Long id) {
        return repo.findById(id).orElseThrow();
    }

    // UPDATE
    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product updated) {
        Product existing = repo.findById(id).orElseThrow();
        existing.setName(updated.getName());
        existing.setPrice(updated.getPrice());
        existing.setCategory(updated.getCategory());
        return repo.save(existing);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        repo.deleteById(id);
        return "Product " + id + " deleted!";
    }
}