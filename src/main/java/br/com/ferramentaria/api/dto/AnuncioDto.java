package br.com.ferramentaria.api.dto;

import javax.validation.constraints.NotEmpty;

import br.com.ferramentaria.api.entity.Anuncio;
import br.com.ferramentaria.api.entity.Ferramenta;
import br.com.ferramentaria.api.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnuncioDto {
	
	@NotEmpty
    private Usuario proprietario;
	
	@NotEmpty
	private Ferramenta ferramenta;
	
	public static Anuncio toModel(AnuncioDto anuncioDto) {
		return new Anuncio(anuncioDto.getProprietario(),
						   anuncioDto.getFerramenta());
	}
}


