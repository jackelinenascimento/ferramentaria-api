package br.com.ferramentaria.api.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ferramentaria.api.dto.ConversaDto;
import br.com.ferramentaria.api.dto.response.ConversaResponse;
import br.com.ferramentaria.api.dto.response.MessageResponseDto;
import br.com.ferramentaria.api.entity.Conversa;
import br.com.ferramentaria.api.repository.ConversaRepository;

@Service
public class ConversaService {
	
	@Autowired
	private ConversaRepository conversaRepository;

	public List<ConversaResponse> listarConversas(Long idUsuario) {
		
		List<Conversa> pesquisa = conversaRepository.findAll();
		
		List<Conversa> pesquisaFiltro = pesquisa.stream().filter(conversa -> conversa.getIdAnunciante().getIdUsuario().equals(idUsuario))
										.collect(Collectors.toList());
		
		return ConversaResponse.converter(pesquisaFiltro);
	}

	public MessageResponseDto cadastrarConversa(@Valid ConversaDto conversaDto) {
		// TODO Auto-generated method stub
		return null;
	}

}
