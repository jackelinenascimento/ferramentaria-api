package br.com.ferramentaria.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ferramentaria.api.dto.response.AnuncioResponse;
import br.com.ferramentaria.api.exceptions.AnuncioNaoEncontrado;
import br.com.ferramentaria.api.service.AnuncioService;

@RestController
@RequestMapping("/anuncios")
@CrossOrigin
public class AnuncioController {

	@Autowired
	private AnuncioService anuncioService;
	
	@GetMapping
	public List<AnuncioResponse> listarAnuncios(){
		return anuncioService.listarAnuncios();
	}
	
	@GetMapping
	public AnuncioResponse pesquisarPorId(@PathVariable Long id) throws AnuncioNaoEncontrado {
		return anuncioService.pesquisarPorId(id);
	}
}
