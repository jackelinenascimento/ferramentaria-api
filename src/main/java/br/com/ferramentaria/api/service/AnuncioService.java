package br.com.ferramentaria.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ferramentaria.api.dto.response.AnuncioResponse;
import br.com.ferramentaria.api.entity.Anuncio;
import br.com.ferramentaria.api.repository.AnuncioRepository;

@Service
public class AnuncioService {

	@Autowired
	private AnuncioRepository anuncioRepository;
	
	public List<AnuncioResponse> listarAnuncios() {
		List<Anuncio> anuncios = anuncioRepository.findAll();
		return AnuncioResponse.converter(anuncios);
	}
}
	