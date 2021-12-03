package br.com.ferramentaria.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.ferramentaria.api.dto.FerramentaDto;
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
	public List<FerramentaDto> listarFerramentas(){
		return ferramentaService.listarFerramentas();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public FerramentaDto cadastrarFerramenta(@RequestBody FerramentaDto ferramentaDto) {
		return ferramentaService.cadastrarFerramenta(ferramentaDto);
	}

}
