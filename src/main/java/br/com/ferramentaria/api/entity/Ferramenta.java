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
import javax.persistence.ManyToOne;

import br.com.ferramentaria.api.entity.enums.Disponibilidade;
import br.com.ferramentaria.api.entity.enums.Modalidade;
import br.com.ferramentaria.api.entity.enums.Status;
import br.com.ferramentaria.api.entity.enums.Tensao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Data
@Entity
@Getter
@Setter	

@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Ferramenta {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFerramenta;
	
	private LocalDateTime dataCadastro = LocalDateTime.now();
	
	@Column(length=30, nullable=true, unique=false)
    private String nome;
	
	@Enumerated(EnumType.STRING)
	private Tensao tensao;

	@Enumerated(EnumType.STRING)
	private Modalidade modalidade;
	
	@Enumerated(EnumType.STRING)
	private Disponibilidade disponibilidade;

	@Column(length=200, nullable=true, unique=false)
    private String descricao;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Foto foto;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Usuario proprietario;
	
	@Enumerated(EnumType.STRING)
	private Status status = Status.ATIVO;
	
	public Ferramenta(String nome,
					  Tensao tensao,
					  Modalidade modalidade,
					  Disponibilidade disponibilidade,
					  String descricao,
					  Foto foto,
					  Usuario proprietario) {
		this.nome = nome;
		this.tensao = tensao;
		this.modalidade = modalidade;
		this.disponibilidade = disponibilidade;
		this.descricao = descricao;
		this.foto = foto;
		this.proprietario = proprietario;
	}
	
	public Long getIdFerramenta() {
		return idFerramenta;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public Tensao getTensao() {
		return tensao;
	}

	public Modalidade getModalidade() {
		return modalidade;
	}

	public Disponibilidade getDisponibilidade() {
		return disponibilidade;
	}
	
	public Foto getFoto() {
		return foto;
	}

	public Usuario getProprietario() {
		return proprietario;
	}
	
	public Status getStatus() {
		return status;
	}
}
