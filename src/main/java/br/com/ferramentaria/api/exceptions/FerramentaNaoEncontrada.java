package br.com.ferramentaria.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FerramentaNaoEncontrada extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public FerramentaNaoEncontrada(Long id) {
		super("Ferramenta não encontrada com ID: " + id);
	}
}
