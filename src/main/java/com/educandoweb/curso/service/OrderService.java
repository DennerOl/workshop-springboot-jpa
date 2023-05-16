package com.educandoweb.curso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.curso.entities.Order;
import com.educandoweb.curso.repositories.OrderRepository;

@Service
public class OrderService {

// injecao de dependencia com a classe do Repository	
	@Autowired
	private OrderRepository repository;
	
// metodo para buscar todos usuarios 
	public List<Order> findAll(){
		return repository.findAll();
	}
	
	
// metodo para buscar o usuario pelo Id	
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
	

	
}
