package br.com.ferramentaria.api.dto.response;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.hateoas.RepresentationModel;

import br.com.ferramentaria.api.entity.Anuncio;
import br.com.ferramentaria.api.entity.Ferramenta;
import br.com.ferramentaria.api.entity.Usuario;
import br.com.ferramentaria.api.entity.enums.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AnuncioResponse extends RepresentationModel<UsuarioResponse> {
	
	private Long idAnuncio;
	private LocalDateTime dataCadastro;
	private Status status;
	private Usuario proprietario;
	private Ferramenta ferramenta;
	
	public AnuncioResponse(Anuncio anuncio) {
		this.idAnuncio = anuncio.getIdAnuncio();
		this.dataCadastro = anuncio.getDataCadastro();
		this.status = anuncio.getStatus();
		this.proprietario = anuncio.getProprietario();
		this.ferramenta = anuncio.getFerramenta();
	}

	public static Page<AnuncioResponse> converter(Page<Anuncio> anuncios) {
		return anuncios.map(AnuncioResponse::new);
	}

}
