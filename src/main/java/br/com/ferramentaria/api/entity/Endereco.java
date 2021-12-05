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
public class Endereco {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long enderecoId;
	
	private String logradouro;
    
	private String complemento;
    
	private String bairro;
    
	private String cidade;
    
	private String uf;
    
	@Column(nullable = true)
	private String cep;
	
	public Endereco(String logradouro, String complemento, String bairro, String cidade, String uf, String cep) {
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
	}

}
