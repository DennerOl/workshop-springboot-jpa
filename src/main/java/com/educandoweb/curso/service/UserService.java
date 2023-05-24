package com.educandoweb.curso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.educandoweb.curso.entities.User;
import com.educandoweb.curso.repositories.UserRepository;
import com.educandoweb.curso.resources.exceptions.DataBaseException;
import com.educandoweb.curso.service.exception.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

// injecao de dependencia com a classe do Repository	
	@Autowired
	private UserRepository repository;
	
// metodo para buscar todos usuarios 
	public List<User> findAll(){
		return repository.findAll();
	}
	
	
/* metodo para buscar o usuario pelo Id	
 * com tratamento de excecao
 */
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	

// salva no banco de dados um usuario
	public User insert(User obj) {
		return repository.save(obj);
	}
	
/* delentando um usuario pelo Id
 * primeira excecao trata de apagar um id que não existe
 * a segunda trata de apagar um id que existe, mas tem vinculo
 * com o um pedido (integridade do banco)
 */
	public void delete(Long id) { 
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage());
		}
	}

/* atualizando um usuario
 * com tratamento de excecao
 */
	public User update(Long id, User obj) {
		try {
			User entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

// metodo auxiliar 
private void updateData(User entity, User obj) {
	entity.setName(obj.getName());
	entity.setEmail(obj.getEmail());
	entity.setPhone(obj.getPhone());
}
	
}
