package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository
        extends JpaRepository<Product, Long>, ProductRepositoryCustom {
    // Spring Data methods on the left
    // Your custom methods on the right
}