package br.com.ferramentaria.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ferramentaria.api.dto.ConversaDto;
import br.com.ferramentaria.api.dto.response.ConversaResponse;
import br.com.ferramentaria.api.dto.response.MessageResponseDto;
import br.com.ferramentaria.api.service.ConversaService;

@RestController
@RequestMapping("/conversas")
@CrossOrigin
public class ConversaController {

	@Autowired
	private ConversaService conversaService;
	
	
	@GetMapping("/{idUsuario}")
	public ResponseEntity<List<ConversaResponse>> listaConversas(@PathVariable Long idUsuario){

		List<ConversaResponse> todasConversas = conversaService.listarConversas(idUsuario);
		
		return new ResponseEntity<List<ConversaResponse>>(todasConversas, HttpStatus.OK);
		
	}
	
	@PostMapping
	public ResponseEntity<MessageResponseDto> cadastrarConversa(@RequestBody @Valid ConversaDto conversaDto){
		
		return new ResponseEntity<MessageResponseDto>(conversaService.cadastrarConversa(conversaDto), HttpStatus.CREATED);
		
	}
	
}
