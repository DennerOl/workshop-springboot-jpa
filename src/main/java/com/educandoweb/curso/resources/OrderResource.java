package com.educandoweb.curso.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.curso.entities.Order;
import com.educandoweb.curso.service.OrderService;

/* esta classe é implementada pela camada
 * 	RestController e tem seu mapeamento
 */
@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

	@Autowired
	private OrderService service;
	
/* endpoint para acessar os usuarios
 * irá retornar respostas de requisições Web
 * por isso é mapeado e com injecao de dependencia
 */

// metodo retorna uma lista de pedidos atraves do service	
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){
		List<Order> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
// metodo retorna um pedido pelo Id informado 		
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id){
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
		
}

