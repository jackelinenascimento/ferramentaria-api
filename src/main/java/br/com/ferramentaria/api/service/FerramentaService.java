package br.com.ferramentaria.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ferramentaria.api.dto.FerramentaDto;
import br.com.ferramentaria.api.dto.response.FerramentaResponse;
import br.com.ferramentaria.api.dto.response.MessageResponseDto;
import br.com.ferramentaria.api.entity.Ferramenta;
import br.com.ferramentaria.api.exceptions.FerramentaNaoEncontrada;
import br.com.ferramentaria.api.exceptions.UsuarioNaoEncontrado;
import br.com.ferramentaria.api.repository.FerramentaRepository;

@Service
public class FerramentaService {

	@Autowired
	private FerramentaRepository ferramentaRepository;
	
	@Autowired UsuarioService usuarioService;
	
	public List<FerramentaResponse> listarFerramentas(){
		List<Ferramenta> ferramentas = ferramentaRepository.findAll();
		return FerramentaResponse.converter(ferramentas);
	}

	public MessageResponseDto cadastrarFerramenta(FerramentaDto ferramentaDto) throws UsuarioNaoEncontrado {
		
		Ferramenta ferramenta = ferramentaRepository.save(FerramentaDto.toModel(ferramentaDto));
		
		MessageResponseDto messageResponse = criarMensagemResposta("Ferramenta salva - ID: ", ferramenta.getIdFerramenta());
		return messageResponse;
	}
	
	private MessageResponseDto criarMensagemResposta(String s, Long id) {
		return MessageResponseDto.message(s + id);
	}

	public FerramentaResponse pesquisaPorId(Long id) throws FerramentaNaoEncontrada {
		Ferramenta ferramenta = verificaSeExistePorId(id);
		return new FerramentaResponse(ferramenta);
	}
	
	public List<FerramentaResponse> persquisaPorProprietarioId(Long id) {
		List<Ferramenta> ferramentas = ferramentaRepository.findByProprietarioIdUsuario(id);
		return FerramentaResponse.converter(ferramentas);
	}

	private Ferramenta verificaSeExistePorId(Long id) throws FerramentaNaoEncontrada {
		return ferramentaRepository.findById(id).orElseThrow(() ->
		new FerramentaNaoEncontrada(id));
	}
}
	