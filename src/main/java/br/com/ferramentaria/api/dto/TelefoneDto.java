package br.com.ferramentaria.api.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import br.com.ferramentaria.api.entity.Telefone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TelefoneDto {
	
	@NotEmpty
	@Size(min=2, max=3)
	private String ddd;
	
	@NotEmpty
	@Size(min=8, max=10)
	private String numero;

	public static Telefone toModel(TelefoneDto telefoneDto) {
		return new Telefone(telefoneDto.getDdd(),
					 telefoneDto.getNumero());
	}

}
