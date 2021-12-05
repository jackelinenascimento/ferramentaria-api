package br.com.ferramentaria.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Telefone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTelefone;
	
	private String ddd;
	
	private String numero;
	
	public Telefone(String ddd, String numero) {
		this.ddd = ddd;
		this.numero = numero;
	}
}
