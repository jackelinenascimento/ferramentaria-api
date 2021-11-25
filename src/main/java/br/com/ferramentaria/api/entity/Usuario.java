package br.com.ferramentaria.api.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Data
@Entity
@Getter
@Setter
@Accessors(chain = true)
public class Usuario {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
	
	private LocalDateTime dataCadastro = LocalDateTime.now();
	
	@Column(length=30, nullable=false, unique=false)
    private String nome;
	
	@Column(length=100, nullable=true, unique=true)
    private String email;

	@Column(nullable = true)
	private String senha;
    
	private String logradouro;
    
	private String complemento;
    
	private String bairro;
    
	private String cidade;
    
	private String uf;
    
	@Column(nullable = true)
	private String cep;
    
    @Column(nullable = true)
    private String telefone;
    
    public Usuario() {};
    
    public Usuario(String nome, String email, String senha, String logradouro, String complemento, String bairro, 
    		String cidade, String uf, String cep, String telefone) {
    	
    	this.nome = nome;
    	this.email = email;
    	this.senha = senha;
    	this.logradouro = logradouro;
    	this.complemento = complemento;
    	this.bairro = bairro;
    	this.cidade = cidade;
    	this.uf = uf;
    	this.cep = cep;
    	this.telefone = telefone;
    }

	public Long getId() {
		return id;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
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

	public String getTelefone() {
		return telefone;
	}
}
