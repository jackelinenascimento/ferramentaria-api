package br.com.ferramentaria.api.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
	
	public Page<AnuncioResponse> listarAnuncios(int pagina, int qtd) {
		
		Pageable paginacao = PageRequest.of(pagina, qtd);
		
		Page<Anuncio> anuncios = anuncioRepository.findAll(paginacao);
		return AnuncioResponse.converter(anuncios);
	}

	public AnuncioResponse pesquisarPorId(Long id) throws AnuncioNaoEncontrado {
		Anuncio anuncio = verificaSeExistePorId(id);
		return new AnuncioResponse(anuncio);
	}

	public MessageResponseDto cadastrarAnuncio(@Valid AnuncioDto anuncioDto) {
		
		Optional<Anuncio> ferramenta = anuncioRepository.findByFerramentaIdFerramenta(anuncioDto.getFerramenta().getIdFerramenta());
		
		if(ferramenta.isPresent()) {
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
	