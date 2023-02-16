package com.onlineshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlineshop.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
