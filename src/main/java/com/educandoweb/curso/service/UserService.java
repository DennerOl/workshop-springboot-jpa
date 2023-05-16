package com.educandoweb.curso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.curso.entities.User;
import com.educandoweb.curso.repositories.UserRepository;

@Service
public class UserService {

// injecao de dependencia com a classe do Repository	
	@Autowired
	private UserRepository repository;
	
// metodo para buscar todos usuarios 
	public List<User> findAll(){
		return repository.findAll();
	}
	
	
// metodo para buscar o usuario pelo Id	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
	

	
}
