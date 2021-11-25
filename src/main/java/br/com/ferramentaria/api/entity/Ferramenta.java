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

import br.com.ferramentaria.api.entity.enums.Modalidade;
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
    @Column(name = "id")
    private Long id;
	
	private LocalDateTime dataCadastro = LocalDateTime.now();
	
	@Column(length=30, nullable=true, unique=false)
    private String nome;
	
	@Column(length=200, nullable=true, unique=false)
    private String descricao;
	
	private String tensao;
	
	@Enumerated(EnumType.STRING)
	private Modalidade modalidade;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Foto foto;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Usuario proprietario;

	public Long getId() {
		return id;
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

	public String getTensao() {
		return tensao;
	}

	public Modalidade getModalidade() {
		return modalidade;
	}

	public Foto getFoto() {
		return foto;
	}

	public Usuario getProprietario() {
		return proprietario;
	}
}
