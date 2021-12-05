package br.com.ferramentaria.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ferramentaria.api.dto.response.AnuncioResponse;
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

	private Anuncio verificaSeExistePorId(Long id) throws AnuncioNaoEncontrado {
		return anuncioRepository.findById(id).orElseThrow(() ->
				new AnuncioNaoEncontrado(id));
	}
}
	