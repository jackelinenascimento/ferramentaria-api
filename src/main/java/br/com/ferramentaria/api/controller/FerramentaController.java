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

import br.com.ferramentaria.api.dto.FerramentaDto;
import br.com.ferramentaria.api.dto.response.FerramentaResponse;
import br.com.ferramentaria.api.dto.response.MessageResponseDto;
import br.com.ferramentaria.api.exceptions.FerramentaNaoEncontrada;
import br.com.ferramentaria.api.exceptions.UsuarioNaoEncontrado;
import br.com.ferramentaria.api.service.FerramentaService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/ferramentas")
@RequiredArgsConstructor
@CrossOrigin
public class FerramentaController {
	
	@Autowired
	private FerramentaService ferramentaService;
	
	@GetMapping
	public ResponseEntity<Page<FerramentaResponse>> listarFerramentas(@RequestParam int pagina, @RequestParam int qtd) throws FerramentaNaoEncontrada{
		
		Page<FerramentaResponse> listaDeFerramentas = ferramentaService.listarFerramentas(pagina, qtd);
		
		for(FerramentaResponse ferramenta : listaDeFerramentas) {
			Long id = ferramenta.getIdFerramenta();
			ferramenta.add(linkTo(methodOn(FerramentaController.class).pesquisarPorId(id)).withSelfRel());
		}
		
		
		return new ResponseEntity<Page<FerramentaResponse>>(listaDeFerramentas, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<FerramentaResponse> pesquisarPorId(@PathVariable Long id) throws FerramentaNaoEncontrada{
		
		return new ResponseEntity<FerramentaResponse>(ferramentaService.pesquisaPorId(id), HttpStatus.OK);
	}
	
	@GetMapping("proprietario/{id}")
	public ResponseEntity<List<FerramentaResponse>> pesquisaPorProprietarioId(@PathVariable Long id) throws UsuarioNaoEncontrado{
		
		return new ResponseEntity<List<FerramentaResponse>>(ferramentaService.persquisaPorProprietarioId(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<MessageResponseDto> cadastrarFerramenta(@RequestBody @Valid FerramentaDto ferramentaDto) throws UsuarioNaoEncontrado {
		
		return new ResponseEntity<MessageResponseDto>(ferramentaService.cadastrarFerramenta(ferramentaDto), HttpStatus.CREATED);
	}

}
	