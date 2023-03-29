package com.ricardocosta.workshopmongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ricardocosta.workshopmongo.domain.User;
import com.ricardocosta.workshopmongo.repository.UserRepository;
import com.ricardocosta.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = repository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado"));
	}
}
