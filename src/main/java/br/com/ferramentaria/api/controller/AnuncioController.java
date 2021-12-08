package br.com.ferramentaria.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.ferramentaria.api.dto.AnuncioDto;
import br.com.ferramentaria.api.dto.response.AnuncioResponse;
import br.com.ferramentaria.api.dto.response.MessageResponseDto;
import br.com.ferramentaria.api.exceptions.AnuncioNaoEncontrado;
import br.com.ferramentaria.api.service.AnuncioService;

@RestController
@RequestMapping("/anuncios")
@CrossOrigin
public class AnuncioController {

	@Autowired
	private AnuncioService anuncioService;
	
	@GetMapping
	public Page<AnuncioResponse> listarAnuncios(@RequestParam int pagina, @RequestParam int qtd){
		return anuncioService.listarAnuncios(pagina, qtd);
	}
	
	@GetMapping("/{id}")
	public AnuncioResponse pesquisarPorId(@PathVariable Long id) throws AnuncioNaoEncontrado {
		return anuncioService.pesquisarPorId(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MessageResponseDto cadastrarAnuncio(@RequestBody @Valid AnuncioDto anuncioDto) {
		return anuncioService.cadastrarAnuncio(anuncioDto);
	}
}
