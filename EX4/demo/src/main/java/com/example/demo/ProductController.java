package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository repo;

    @GetMapping
    public Page<Product> getAll(
        @RequestParam(defaultValue = "0")    int page,
        @RequestParam(defaultValue = "3")    int size,
        @RequestParam(defaultValue = "id")   String sortBy,
        @RequestParam(defaultValue = "asc")  String direction
    ) {
        Sort sort = direction.equalsIgnoreCase("desc")
            ? Sort.by(sortBy).descending()
            : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);
        return repo.findAll(pageable);
    }
}