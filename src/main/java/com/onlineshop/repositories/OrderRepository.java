package com.onlineshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlineshop.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
