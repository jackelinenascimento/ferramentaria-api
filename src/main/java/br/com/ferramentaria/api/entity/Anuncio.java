package br.com.ferramentaria.api.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import br.com.ferramentaria.api.entity.enums.Status;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Anuncio {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAnuncio;
	
	private LocalDateTime dataCadastro = LocalDateTime.now();
	
	@Enumerated(EnumType.STRING)
	private Status status = Status.ATIVO;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	private Usuario proprietario;
	
	@OneToOne(cascade=CascadeType.MERGE)
	private Ferramenta ferramenta;
	
	public Anuncio(Usuario proprietario, Ferramenta ferramenta) {
		this.proprietario = proprietario;
		this.ferramenta= ferramenta;
	}
}
