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
import br.com.ferramentaria.api.dto.mapper.ConversaMapper;
import br.com.ferramentaria.api.dto.response.ConversaResponse;
import br.com.ferramentaria.api.dto.response.MensagemResponse;
import br.com.ferramentaria.api.dto.response.MessageResponseDto;
import br.com.ferramentaria.api.entity.Anuncio;
import br.com.ferramentaria.api.entity.Usuario;
import br.com.ferramentaria.api.service.AnuncioService;
import br.com.ferramentaria.api.service.ConversaService;
import br.com.ferramentaria.api.service.MensagemService;
import br.com.ferramentaria.api.service.UsuarioService;

@RestController
@RequestMapping("/conversas")
@CrossOrigin
public class ConversaController {

	@Autowired
	private ConversaService conversaService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private AnuncioService anuncioService;
	
	@Autowired
	private MensagemService mensagemService;
	
	@GetMapping("usuario/{idUsuario}")
	public ResponseEntity<List<ConversaResponse>> listaConversas(@PathVariable Long idAnunciante){

		List<ConversaResponse> todasConversas = conversaService.listarConversas(idAnunciante);
		
		return new ResponseEntity<List<ConversaResponse>>(todasConversas, HttpStatus.OK);
		
	}
	
	@GetMapping("/{id}/mensagens")
	public ResponseEntity<List<MensagemResponse>> listaMensagens(@PathVariable Long idConversa){
		
		List<MensagemResponse> todasMensagens = mensagemService.listarMensagens(idConversa);

		return new ResponseEntity<List<MensagemResponse>>(todasMensagens, HttpStatus.OK);
		
	}
	
	@PostMapping
	public ResponseEntity<MessageResponseDto> cadastrarConversa(@RequestBody @Valid ConversaMapper conversaMapper){
		
		Usuario anunciante = usuarioService.verificaSeExistePorId(conversaMapper.getIdAnunciante());
		Usuario interessado = usuarioService.verificaSeExistePorId(conversaMapper.getIdInteressado());
		Anuncio anuncio = anuncioService.verificaSeExistePorId(conversaMapper.getIdAnuncio());
		
		ConversaDto conversaDto = new ConversaDto(anunciante, interessado, anuncio);
		
		return new ResponseEntity<MessageResponseDto>(conversaService.cadastrarConversa(conversaDto), HttpStatus.CREATED);
		
	}
	
}
