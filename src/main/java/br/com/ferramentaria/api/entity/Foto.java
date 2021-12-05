package br.com.ferramentaria.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Foto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFoto;
	
	@Column(nullable = false)
	private String caminho;
	
	public Foto(String caminho) {
		this.caminho = caminho;
	}

	public String getCaminho() {
		return caminho;
	}
}
