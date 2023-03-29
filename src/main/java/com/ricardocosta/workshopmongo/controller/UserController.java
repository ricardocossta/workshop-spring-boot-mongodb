package com.ricardocosta.workshopmongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ricardocosta.workshopmongo.domain.User;
import com.ricardocosta.workshopmongo.dto.UserDTO;
import com.ricardocosta.workshopmongo.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	private UserService service;

	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> userList = service.findAll();
		List<UserDTO> userDtoList = userList.stream()
				.map(u -> new UserDTO(u))
				.toList();
		return ResponseEntity.ok().body(userDtoList);
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		User user = service.findById(id);
		return ResponseEntity.ok().body(new UserDTO(user));
	}

	
	
}
