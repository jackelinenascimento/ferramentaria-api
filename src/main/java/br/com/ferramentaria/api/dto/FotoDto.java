package br.com.ferramentaria.api.dto;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FotoDto {
	
	private Long idFoto;
	
	@NotEmpty
	private String caminho;
		
}
