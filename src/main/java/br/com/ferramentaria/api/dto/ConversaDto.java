package br.com.ferramentaria.api.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import br.com.ferramentaria.api.entity.Anuncio;
import br.com.ferramentaria.api.entity.Conversa;
import br.com.ferramentaria.api.entity.Usuario;

public class ConversaDto {
	
	@NotEmpty
	private Usuario idAnunciante;
	
	@NotEmpty
	private Usuario idInteressado;
	
	@NotEmpty
	private Anuncio idAnuncio;

	public static Conversa toModel(@Valid ConversaDto conversaDto) {
		return new Conversa(conversaDto.idAnunciante,
							conversaDto.idInteressado,
							conversaDto.idAnuncio);
	}

}
