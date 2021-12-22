package br.com.ferramentaria.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	public ResponseEntity<List<UsuarioResponse>> listaUsuarios() throws UsuarioNaoEncontrado{
		
		List<UsuarioResponse> listaDeUsuarios = usuarioService.listaUsuarios();	
		for(UsuarioResponse usuario: listaDeUsuarios) {
				Long id = usuario.getIdUsuario();
				usuario.add(linkTo(methodOn(UsuarioController.class).pesquisarPorId(id)).withSelfRel());
		}
		
		return new ResponseEntity<List<UsuarioResponse>>(listaDeUsuarios, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioResponse> pesquisarPorId(@PathVariable Long id) throws UsuarioNaoEncontrado {
		
		Optional<UsuarioResponse> usuarioPesquisado = Optional.ofNullable(usuarioService.pesquisarPorId(id));
		usuarioPesquisado.get().add(linkTo(methodOn(UsuarioController.class).listaUsuarios()).withRel("Lista de Usuários"));

		return new ResponseEntity<UsuarioResponse>(usuarioPesquisado.get(), HttpStatus.OK);
	}
	
	@GetMapping("/email/{email}")
	public ResponseEntity<UsuarioResponse> pesquisarPorEmail(@PathVariable String email) throws UsuarioNaoEncontrado {
		
		Optional<UsuarioResponse> usuarioPesquisado = Optional.ofNullable(usuarioService.pesquisarPorEmail(email));	
		usuarioPesquisado.get().add(linkTo(methodOn(UsuarioController.class).listaUsuarios()).withRel("Lista de Usuários"));

		return new ResponseEntity<UsuarioResponse>(usuarioPesquisado.get(), HttpStatus.OK);
	}
	
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDto cadastrarUsuario(@RequestBody @Valid UsuarioDto usuarioDto){
        return usuarioService.cadastrarUsuario(usuarioDto);
    }
	
}	
