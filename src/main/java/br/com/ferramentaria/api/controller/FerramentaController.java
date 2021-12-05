package br.com.ferramentaria.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	public List<FerramentaResponse> listarFerramentas(){
		return ferramentaService.listarFerramentas();
	}
	
	@GetMapping("/{id}")
	public FerramentaResponse pesquisarPorId(@PathVariable Long id) throws FerramentaNaoEncontrada{
		return ferramentaService.pesquisaPorId(id);
	}
	
	@GetMapping("proprietario/{id}")
	public List<FerramentaResponse> pesquisaPorProprietarioId(@PathVariable Long id) throws UsuarioNaoEncontrado{
		return ferramentaService.persquisaPorProprietarioId(id);	
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MessageResponseDto cadastrarFerramenta(@RequestBody @Valid FerramentaDto ferramentaDto) throws UsuarioNaoEncontrado {
		return ferramentaService.cadastrarFerramenta(ferramentaDto);
	}

}
	