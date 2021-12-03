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
	public List<UsuarioResponse> listaUsuarios(){
		return usuarioService.listaUsuarios();
	}
	
	@GetMapping("/{id}")
	public UsuarioDto pesquisarPorId(@PathVariable Long id) throws UsuarioNaoEncontrado {
		return usuarioService.pesquisarPorId(id);
	}
	
	@GetMapping("/email/{email}")
	public UsuarioDto pesquisarPorEmail(@PathVariable String email) throws UsuarioNaoEncontrado {
		return usuarioService.pesquisarPorEmail(email);
	}
	
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDto cadastrarUsuario(@RequestBody @Valid UsuarioDto usuarioDto){
        return usuarioService.cadastrarUsuario(usuarioDto);
    }
	
}	
