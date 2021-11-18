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

import br.com.ferramentaria.api.dto.UsuarioDto;
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
	public List<UsuarioDto> listaUsuarios(){
		return usuarioService.listaUsuarios();
	}
	
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioDto cadastrarUsuario(@RequestBody UsuarioDto usuarioDto){
        return usuarioService.cadastrarUsuario(usuarioDto);
    }
}	