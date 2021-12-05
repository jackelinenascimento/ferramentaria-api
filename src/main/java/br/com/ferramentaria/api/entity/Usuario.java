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
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
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
    	
	@OneToOne(cascade=CascadeType.PERSIST)
	private Endereco endereco;
    
	@OneToOne(cascade=CascadeType.PERSIST)
    private Telefone telefone;
	
	@Enumerated(EnumType.STRING)
	private Status status = Status.ATIVO;
    
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

}
