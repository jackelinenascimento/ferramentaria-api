package br.com.ferramentaria.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AnuncioNaoEncontrado extends Exception {

	private static final long serialVersionUID = 1L;
	
	public AnuncioNaoEncontrado(Long id) {
		super("Anuncio não encontrado com ID: " + id);
	}

}
