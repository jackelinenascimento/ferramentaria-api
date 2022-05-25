package br.com.ferramentaria.api.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ferramentaria.api.dto.AnuncioDto;
import br.com.ferramentaria.api.dto.mapper.AnuncioMapper;
import br.com.ferramentaria.api.dto.response.AnuncioResponse;
import br.com.ferramentaria.api.dto.response.MessageResponseDto;
import br.com.ferramentaria.api.entity.Ferramenta;
import br.com.ferramentaria.api.entity.Usuario;
import br.com.ferramentaria.api.exceptions.AnuncioNaoEncontrado;
import br.com.ferramentaria.api.exceptions.FerramentaNaoEncontrada;
import br.com.ferramentaria.api.exceptions.UsuarioNaoEncontrado;
import br.com.ferramentaria.api.service.AnuncioService;
import br.com.ferramentaria.api.service.FerramentaService;
import br.com.ferramentaria.api.service.UsuarioService;

@RestController
@RequestMapping("/anuncios")	
@CrossOrigin
public class AnuncioController {

	@Autowired
	private AnuncioService anuncioService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private FerramentaService ferramentaService;
	
	@GetMapping
	public ResponseEntity<Page<AnuncioResponse>> listarAnuncios(@RequestParam int pagina, @RequestParam int qtd) throws AnuncioNaoEncontrado{
		
		Page<AnuncioResponse> listaDeAnuncios = anuncioService.listarAnuncios(pagina, qtd);
		
		for(AnuncioResponse anuncio : listaDeAnuncios) {
			anuncio.add(linkTo(methodOn(AnuncioController.class).pesquisarPorId(anuncio.getIdAnuncio())).withSelfRel());
		}
		
		return new ResponseEntity<Page<AnuncioResponse>>(listaDeAnuncios, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AnuncioResponse> pesquisarPorId(@PathVariable Long id) throws AnuncioNaoEncontrado {
		
		return new ResponseEntity<AnuncioResponse>(anuncioService.pesquisarPorId(id), HttpStatus.OK);

	}
	
	@GetMapping("/proprietario/{id}")
	public ResponseEntity<List<AnuncioResponse>> pesquisaPorProprietarioId(@PathVariable Long id) throws UsuarioNaoEncontrado{
		
		return new ResponseEntity<List<AnuncioResponse>>(anuncioService.persquisaPorProprietarioId(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<MessageResponseDto> cadastrarAnuncio(@RequestBody @Valid AnuncioMapper anuncioMapper) throws UsuarioNaoEncontrado, FerramentaNaoEncontrada {
				
		Usuario proprietario = usuarioService.verificaSeExistePorId(anuncioMapper.getProprietarioId());
		Ferramenta ferramenta = ferramentaService.verificaSeExistePorId(anuncioMapper.getFerramentaId());
		
		AnuncioDto anuncioDto = new AnuncioDto(proprietario, ferramenta);

		return new ResponseEntity<MessageResponseDto>(anuncioService.cadastrarAnuncio(anuncioDto), HttpStatus.CREATED);
	}
}
