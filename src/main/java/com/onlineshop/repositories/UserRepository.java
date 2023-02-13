package com.onlineshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlineshop.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
