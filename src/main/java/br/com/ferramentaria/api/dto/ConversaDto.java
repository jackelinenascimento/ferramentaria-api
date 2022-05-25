package br.com.ferramentaria.api.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.ferramentaria.api.entity.Anuncio;
import br.com.ferramentaria.api.entity.Conversa;
import br.com.ferramentaria.api.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConversaDto {
	
	@NotNull
	private Long idAnunciante;
	
	@NotEmpty
	private Usuario anunciante;
	
	@NotNull
	private Long idInteressado;
	
	@NotEmpty
	private Usuario interessado;
	
	@NotNull
	private Long idAnuncio;
	
	@NotEmpty
	private Anuncio anuncio;
	
	public ConversaDto(Usuario anunciante, Usuario interessado, Anuncio anuncio) {
		this.anunciante = anunciante;
		this.interessado = interessado;
		this.anuncio = anuncio;
	}

	public static Conversa toModel(ConversaDto conversaDto) {
		return new Conversa(conversaDto.anunciante,
							conversaDto.interessado,
							conversaDto.anuncio);
	}

}
