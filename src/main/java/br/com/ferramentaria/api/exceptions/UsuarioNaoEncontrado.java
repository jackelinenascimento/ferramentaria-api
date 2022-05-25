package br.com.ferramentaria.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UsuarioNaoEncontrado extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public UsuarioNaoEncontrado(Long id) {
		super("Usuario não encontrado com ID: " + id);
	}

	public UsuarioNaoEncontrado(String email) {
		super("Usuario não encontrado com o email: " + email);
	}
}
