package br.com.ferramentaria.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Data
@Entity
@Getter
@Setter
@Accessors(chain = true)
public class Endereco {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
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

	public Long getEnderecoId() {
		return enderecoId;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public String getUf() {
		return uf;
	}

	public String getCep() {
		return cep;
	}
}
