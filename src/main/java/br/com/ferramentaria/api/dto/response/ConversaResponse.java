package br.com.ferramentaria.api.dto.response;

import java.util.List;
import java.util.stream.Collectors;

import br.com.ferramentaria.api.entity.Anuncio;
import br.com.ferramentaria.api.entity.Conversa;
import br.com.ferramentaria.api.entity.Usuario;
import br.com.ferramentaria.api.entity.enums.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ConversaResponse {

	private Long idConversa;
	
	private Status status;
	
	private Usuario idInteressado;
	
	private Anuncio idAnuncio;
	
	public ConversaResponse(Conversa conversa) {
		this.idConversa = conversa.getIdConversa();
		this.status = conversa.getStatus();
		this.idInteressado = conversa.getIdInteressado();
		this.idAnuncio = conversa.getIdAnuncio();
	}
	
	public static List<ConversaResponse> converter(List<Conversa> conversas){
		
		List<ConversaResponse> result = conversas.stream()
												 .map(ConversaResponse::new)
												 .collect(Collectors.toList());
		
		return result;
	}
}
