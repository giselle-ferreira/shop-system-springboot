package com.onlineshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlineshop.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
