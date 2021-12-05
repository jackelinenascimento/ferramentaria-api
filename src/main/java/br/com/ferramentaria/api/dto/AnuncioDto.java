package br.com.ferramentaria.api.dto;

import br.com.ferramentaria.api.entity.Anuncio;
import br.com.ferramentaria.api.entity.Ferramenta;
import br.com.ferramentaria.api.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnuncioDto {
	
    private Usuario proprietario;
	private Ferramenta ferramenta;
	
	public static Anuncio toModel(AnuncioDto anuncioDto) {
		return new Anuncio(anuncioDto.getProprietario(),
						   anuncioDto.getFerramenta());
	}
}


