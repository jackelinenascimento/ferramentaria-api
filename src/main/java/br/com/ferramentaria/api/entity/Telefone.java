package br.com.ferramentaria.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Telefone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTelefone;
	
	private String ddd;
	
	private String numero;
	
	public Telefone() {};
	
	public Telefone(String ddd, String numero) {
		this.ddd = ddd;
		this.numero = numero;
	}
	
	public Long getIdTelefone() {
		return idTelefone;
	}
	public String getDdd() {
		return ddd;
	}
	public String getNumero() {
		return numero;
	}
}
