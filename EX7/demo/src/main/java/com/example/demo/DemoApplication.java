package com.example.demo;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner seed(ProductRepository repo) {
        return args -> {
            repo.save(new Product(null, "Laptop",    999.99, "Electronics"));
            repo.save(new Product(null, "Phone",     599.99, "Electronics"));
            repo.save(new Product(null, "Desk",      249.00, "Furniture"));
            repo.save(new Product(null, "Chair",     189.00, "Furniture"));
            repo.save(new Product(null, "Keyboard",   89.99, "Electronics"));
        };
    }
}