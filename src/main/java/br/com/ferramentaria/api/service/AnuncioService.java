package br.com.ferramentaria.api.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ferramentaria.api.dto.AnuncioDto;
import br.com.ferramentaria.api.dto.response.AnuncioResponse;
import br.com.ferramentaria.api.dto.response.MessageResponseDto;
import br.com.ferramentaria.api.entity.Anuncio;
import br.com.ferramentaria.api.exceptions.AnuncioNaoEncontrado;
import br.com.ferramentaria.api.repository.AnuncioRepository;

@Service
public class AnuncioService {

	@Autowired
	private AnuncioRepository anuncioRepository;
	
	public List<AnuncioResponse> listarAnuncios() {
		List<Anuncio> anuncios = anuncioRepository.findAll();
		return AnuncioResponse.converter(anuncios);
	}

	public AnuncioResponse pesquisarPorId(Long id) throws AnuncioNaoEncontrado {
		Anuncio anuncio = verificaSeExistePorId(id);
		return new AnuncioResponse(anuncio);
	}

	public MessageResponseDto cadastrarAnuncio(@Valid AnuncioDto anuncioDto) {
		
		Optional<Anuncio> anuncio = anuncioRepository.findByFerramentaIdFerramenta(anuncioDto.getFerramenta().getIdFerramenta());
		
		if(anuncio.isPresent()) {
			throw new IllegalArgumentException("Ferramenta já publicada");
		}
		
		Anuncio anuncioSalvo = anuncioRepository.save(AnuncioDto.toModel(anuncioDto));
		return MessageResponseDto.message("Anuncio salvo - ID: " +  anuncioSalvo.getIdAnuncio());
	}

	private Anuncio verificaSeExistePorId(Long id) throws AnuncioNaoEncontrado {
		return anuncioRepository.findById(id).orElseThrow(() ->
				new AnuncioNaoEncontrado(id));
	}
}
	