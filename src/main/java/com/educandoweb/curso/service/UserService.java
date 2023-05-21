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
	

// salva no banco de dados um usuario
	public User insert(User obj) {
		return repository.save(obj);
	}
	
// delentando um usuario pelo Id
	public void delete(Long id) {
		repository.deleteById(id);
	}

// atualizando um usuario
	public User update(Long id, User obj) {
		User entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

// metodo auxiliar 
private void updateData(User entity, User obj) {
	entity.setName(obj.getName());
	entity.setEmail(obj.getEmail());
	entity.setPhone(obj.getPhone());
}
	
}
