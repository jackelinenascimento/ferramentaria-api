package br.com.ferramentaria.api.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ferramentaria.api.dto.UsuarioDto;
import br.com.ferramentaria.api.dto.response.MessageResponseDto;
import br.com.ferramentaria.api.dto.response.UsuarioResponse;
import br.com.ferramentaria.api.exceptions.UsuarioNaoEncontrado;
import br.com.ferramentaria.api.service.UsuarioService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
@CrossOrigin
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	public ResponseEntity<Page<UsuarioResponse>> listaUsuarios(@RequestParam int pagina, @RequestParam int qtd) throws UsuarioNaoEncontrado{
		
		Page<UsuarioResponse> listaDeUsuarios = usuarioService.listaUsuarios(pagina, qtd);	
		
		for(UsuarioResponse usuario: listaDeUsuarios) {		
				usuario.add(linkTo(methodOn(UsuarioController.class).pesquisarPorId(usuario.getIdUsuario())).withSelfRel());
				usuario.add(linkTo(methodOn(UsuarioController.class).pesquisarPorEmail(usuario.getEmail())).withSelfRel());
		}
		
		return new ResponseEntity<Page<UsuarioResponse>>(listaDeUsuarios, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioResponse> pesquisarPorId(@PathVariable Long id) throws UsuarioNaoEncontrado {
		
		return new ResponseEntity<UsuarioResponse>(usuarioService.pesquisarPorId(id), HttpStatus.OK);
	}
	
	@GetMapping("/email/{email}")
	public ResponseEntity<UsuarioResponse> pesquisarPorEmail(@PathVariable String email) throws UsuarioNaoEncontrado {

		return new ResponseEntity<UsuarioResponse>(usuarioService.pesquisarPorEmail(email), HttpStatus.OK);
	}
	
	@PostMapping
    public ResponseEntity<MessageResponseDto> cadastrarUsuario(@RequestBody @Valid UsuarioDto usuarioDto){
        
        return new ResponseEntity<MessageResponseDto>(usuarioService.cadastrarUsuario(usuarioDto), HttpStatus.CREATED);
        
    }
	
	@PutMapping("/{id}")
	public ResponseEntity<MessageResponseDto> atualizarDados(@PathVariable Long id, @RequestBody @Valid UsuarioDto usuarioDto) throws UsuarioNaoEncontrado{
		
		return new ResponseEntity<MessageResponseDto>(usuarioService.atualizarDadosUsuario(id, usuarioDto), HttpStatus.OK);
	}
	
}	
