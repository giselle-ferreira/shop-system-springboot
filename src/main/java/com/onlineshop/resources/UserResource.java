package com.onlineshop.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineshop.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<User> findAllUsers() {
		User user1 = new User(1L, "Maria", "a@gmail.com", "99999", "12345");
		return ResponseEntity.ok().body(user1);
	}
}
