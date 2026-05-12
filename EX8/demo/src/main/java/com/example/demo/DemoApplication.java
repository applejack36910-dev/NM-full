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
            repo.save(new Product(null, "Laptop",   999.99, "Electronics"));
            repo.save(new Product(null, "Phone",    599.99, "Electronics"));
            repo.save(new Product(null, "Desk",     249.00, "Furniture"));
        };
    }
}

/*CREATE
POST http://localhost:8080/products
Body → raw → JSON:
{
    "name": "Keyboard",
    "price": 89.99,
    "category": "Electronics"
}
READ ALL
GET http://localhost:8080/products
READ ONE
GET http://localhost:8080/products/1
UPDATE
PUT http://localhost:8080/products/1
Body → raw → JSON:
{
    "name": "Gaming Laptop",
    "price": 1299.99,
    "category": "Electronics"
}
DELETE
DELETE http://localhost:8080/products/1*/
