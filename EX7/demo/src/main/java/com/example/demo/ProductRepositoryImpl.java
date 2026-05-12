package com.example.demo;

import jakarta.persistence.*;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Product> findExpensiveProducts(Double minPrice) {
        return em.createQuery(
            "SELECT p FROM Product p WHERE p.price > :price ORDER BY p.price DESC",
            Product.class)
            .setParameter("price", minPrice)
            .getResultList();
    }

    @Override
    public List<Product> findByKeyword(String keyword) {
        return em.createQuery(
            "SELECT p FROM Product p WHERE p.name LIKE :keyword OR p.category LIKE :keyword",
            Product.class)
            .setParameter("keyword", "%" + keyword + "%")
            .getResultList();
    }
}