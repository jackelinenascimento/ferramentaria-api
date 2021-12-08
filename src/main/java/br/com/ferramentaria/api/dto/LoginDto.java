package br.com.ferramentaria.api.dto;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import lombok.Setter;

@Setter
public class LoginDto {
	
	private String email;
	private String senha;
	
	public UsernamePasswordAuthenticationToken converter() {
		return new UsernamePasswordAuthenticationToken(email, senha);
	}

}
