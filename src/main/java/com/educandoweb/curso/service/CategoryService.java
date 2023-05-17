package com.educandoweb.curso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.curso.entities.Category;
import com.educandoweb.curso.repositories.CategoryRepository;

@Service
public class CategoryService {

// injecao de dependencia com a classe do Repository	
	@Autowired
	private CategoryRepository repository;
	
// metodo para buscar todas categoria
	public List<Category> findAll(){
		return repository.findAll();
	}
	
	
// metodo para buscar a categoria pelo Id	
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}
	

	
}
