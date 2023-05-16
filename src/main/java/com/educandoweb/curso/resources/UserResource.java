package com.educandoweb.curso.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.curso.entities.User;
import com.educandoweb.curso.service.UserService;

/* esta classe é implementada pela camada
 * 	RestController e tem seu mapeamento
 */
@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;
	
/* endpoint para acessar os usuarios
 * irá retornar respostas de requisições Web
 * por isso é mapeado e com injecao de dependencia
 */

// metodo retorna uma lista de usuarios atraves do service	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
// metodo retorna um usuario pelo Id informado 		
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
		
}

