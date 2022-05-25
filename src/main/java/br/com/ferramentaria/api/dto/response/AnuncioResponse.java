package br.com.ferramentaria.api.dto.response;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.hateoas.RepresentationModel;

import br.com.ferramentaria.api.entity.Anuncio;
import br.com.ferramentaria.api.entity.enums.Disponibilidade;
import br.com.ferramentaria.api.entity.enums.Modalidade;
import br.com.ferramentaria.api.entity.enums.Status;
import br.com.ferramentaria.api.entity.enums.Tensao;
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
	private Long proprietarioId;
	private Long ferramentaId;
	private String nomeFerramenta;
	private Tensao tensaoFerramenta;
	private Modalidade modalidadeFerramenta;
	private Disponibilidade disponibilidadeFerramenta;
	private String descricaoFerramenta;

	public AnuncioResponse(Anuncio anuncio) {
		this.idAnuncio = anuncio.getIdAnuncio();
		this.dataCadastro = anuncio.getDataCadastro();
		this.status = anuncio.getStatus();
		this.proprietarioId = anuncio.getProprietario().getIdUsuario();
		this.ferramentaId = anuncio.getFerramenta().getIdFerramenta();
		this.nomeFerramenta = anuncio.getFerramenta().getNome();
		this.tensaoFerramenta = anuncio.getFerramenta().getTensao();
		this.modalidadeFerramenta = anuncio.getFerramenta().getModalidade();
		this.disponibilidadeFerramenta = anuncio.getFerramenta().getDisponibilidade();
		this.descricaoFerramenta = anuncio.getFerramenta().getDescricao();
	}


	public static Page<AnuncioResponse> converter(Page<Anuncio> anuncios) {
		return anuncios.map(AnuncioResponse::new);
	}

	public static List<AnuncioResponse> converter(List<Anuncio> anuncios) {
		return anuncios.stream().map(AnuncioResponse::new).collect(Collectors.toList());
	}
}

