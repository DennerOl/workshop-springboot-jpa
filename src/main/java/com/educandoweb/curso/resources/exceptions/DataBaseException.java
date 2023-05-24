package com.educandoweb.curso.resources.exceptions;

// trata a excecao do delete da classe userService
public class DataBaseException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public DataBaseException(String msg) {
		super(msg);
	}
}
