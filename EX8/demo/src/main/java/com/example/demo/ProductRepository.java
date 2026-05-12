package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // save()     → Create & Update
    // findAll()  → Read all
    // findById() → Read one
    // deleteById() → Delete
}