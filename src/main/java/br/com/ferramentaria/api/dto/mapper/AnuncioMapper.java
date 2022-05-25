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
public class AnuncioMapper {

	@NotNull
	private Long proprietarioId;
	
	@NotNull
	private Long ferramentaId;
	
}
