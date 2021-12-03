package br.com.ferramentaria.api.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import br.com.ferramentaria.api.entity.enums.Status;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
public class Usuario {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
	
	private LocalDateTime dataCadastro = LocalDateTime.now();
	
	@Column(length=30, nullable=false, unique=false)
    private String nome;
	
	@Column(length=100, nullable=true, unique=true)
    private String email;

	@Column(nullable = true)
	private String senha;
    	
	@OneToOne(cascade = CascadeType.ALL)
	private Endereco endereco;
    
	@OneToOne(cascade = CascadeType.ALL)	
    private Telefone telefone;
	
	@Enumerated(EnumType.STRING)
	private Status status = Status.ATIVO;
    
    public Usuario() {};
    
    public Usuario(String nome,
    			   String email,
    			   String senha,
    			   Endereco endereco,
    			   Telefone telefone) {
    	
    	this.nome = nome;
    	this.email = email;
    	this.senha = senha;
    	this.endereco = endereco;
    	this.telefone = telefone;
    }

	public Long getIdUsuario() {
		return idUsuario;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	@SuppressWarnings("unused")
	private void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public Telefone getTelefone() {
		return telefone;
	}
	
	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}
}
