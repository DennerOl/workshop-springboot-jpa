package com.educandoweb.curso.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.curso.entities.User;

/* esta classe é implementada pela camada
 * 	RestController e tem seu mapeamento
 */
@RestController
@RequestMapping(value = "/users")
public class UserResource {

/* Metodo que vai ser um endpoint para 
 * 	acessar os usuarios
 * irá retornar respostas de requisições Web
 * por isso é mapeado
  */

	@GetMapping
	public ResponseEntity<User> findAll(){
		User u = new User(1L,"Maria", "maria@gmail.com", "999999","12345");
		return ResponseEntity.ok().body(u);
	}
}
