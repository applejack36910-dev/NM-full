package com.example.demo;

import java.util.List;

public interface ProductRepositoryCustom {

    List<Product> findExpensiveProducts(Double minPrice);
    List<Product> findByKeyword(String keyword);
}