package br.com.ferramentaria.api.dto.mapper;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConversaMapper {

	@NotNull
	private Long idAnunciante;
	
	@NotNull
	private Long idInteressado;
	
	@NotNull
	private Long idAnuncio;

}
