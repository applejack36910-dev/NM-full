package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // save() and findById() are already built in — nothing extra needed!
}