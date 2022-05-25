package br.com.ferramentaria.api.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.ferramentaria.api.entity.Conversa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MensagemDto {

	@NotNull
	private Conversa idConversa;
	
	@NotEmpty
	private String mensagem;
	
}
