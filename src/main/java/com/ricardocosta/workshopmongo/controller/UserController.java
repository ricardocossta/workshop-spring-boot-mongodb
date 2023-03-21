package com.ricardocosta.workshopmongo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ricardocosta.workshopmongo.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@GetMapping
	public ResponseEntity<List<User>>  findAll() {
		User u1 = new User("1", "Ricardo", "teste");
		User u2 = new User("2", "João", "teste");
		
		return ResponseEntity.ok().body(List.of(u1, u2));
	}
	
}
