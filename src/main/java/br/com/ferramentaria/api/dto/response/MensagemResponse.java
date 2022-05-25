package br.com.ferramentaria.api.dto.response;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.ferramentaria.api.entity.Mensagem;
import br.com.ferramentaria.api.entity.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MensagemResponse {
	
	private Long idMensagem;
	
	private LocalDateTime data;
	
	private Status status;
	
	private String mensagem;
	
	public MensagemResponse(Mensagem mensagem) {
		this.idMensagem = mensagem.getIdMensagem();
		this.data = mensagem.getData();
		this.status = mensagem.getStatus();
		this.mensagem = mensagem.getMensagem();
	}

	public static List<MensagemResponse> converter(List<Mensagem> todasMensagens) {
		List<MensagemResponse> result = todasMensagens.stream()
				 .map(MensagemResponse::new)
				 .collect(Collectors.toList());

		return result;
	}

}
