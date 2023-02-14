package com.onlineshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlineshop.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
