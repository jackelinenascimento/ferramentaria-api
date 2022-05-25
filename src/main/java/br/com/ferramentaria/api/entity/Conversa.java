package br.com.ferramentaria.api.entity;

import javax.persistence.CascadeType;
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
public class Conversa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idConversa;
	
	@Enumerated(EnumType.STRING)
	private Status status = Status.ATIVO;
	
	@OneToOne(cascade=CascadeType.MERGE)
	private Usuario idAnunciante;
	
	@OneToOne(cascade=CascadeType.MERGE)
	private Usuario idInteressado;
	
	@OneToOne(cascade=CascadeType.MERGE)
	private Anuncio idAnuncio;

	public Conversa(Usuario idAnunciante, Usuario idInteressado, Anuncio idAnuncio) {
		this.idAnunciante = idAnunciante;
		this.idInteressado = idInteressado;
		this.idAnuncio = idAnuncio;
	}
}
