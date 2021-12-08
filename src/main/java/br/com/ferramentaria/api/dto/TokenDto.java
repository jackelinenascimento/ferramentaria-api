package br.com.ferramentaria.api.dto;

import lombok.Getter;

@Getter
public class TokenDto {
	
	private String token;
	private String tipo;
	private String mensagem;

	public TokenDto(String token, String tipo) {
		this.token = token;
		this.tipo = tipo;
	}

	public TokenDto(String mensagem) {
		this.mensagem = mensagem;
	}
}
