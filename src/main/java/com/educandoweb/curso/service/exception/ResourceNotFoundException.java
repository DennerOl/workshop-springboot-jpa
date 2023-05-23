package com.educandoweb.curso.service.exception;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

/* tratamento da excecao do metodo de buscar um usuario pelo
 * 	id ou seja se eu buscar um usuario que não possui no banco
 apresento esta excecao */
	public ResourceNotFoundException(Object id) {
		super(" ID não encontrado " + id);
	}
	
}
