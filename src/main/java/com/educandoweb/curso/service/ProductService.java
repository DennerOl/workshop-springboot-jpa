package com.educandoweb.curso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.curso.entities.Product;
import com.educandoweb.curso.repositories.ProductRepository;

@Service
public class ProductService {

// injecao de dependencia com a classe do Repository	
	@Autowired
	private ProductRepository repository;
	
// metodo para buscar todos produtos 
	public List<Product> findAll(){
		return repository.findAll();
	}
	
	
// metodo para buscar o produto pelo Id	
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}
	

	
}
