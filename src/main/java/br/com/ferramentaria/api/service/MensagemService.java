package br.com.ferramentaria.api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ferramentaria.api.dto.response.MensagemResponse;
import br.com.ferramentaria.api.entity.Mensagem;
import br.com.ferramentaria.api.repository.MensagemRepository;

@Service
public class MensagemService {
	
	@Autowired
	private MensagemRepository mensagemRepository;

	public List<MensagemResponse> listarMensagens(Long idConversa) {
		
		List<Mensagem> todasMensagens = mensagemRepository.findAll();
		
		todasMensagens = todasMensagens.stream().filter(mensagem -> mensagem.getIdConversa().getIdConversa().equals(idConversa))
				.collect(Collectors.toList());

		return MensagemResponse.converter(todasMensagens);
	}

}
