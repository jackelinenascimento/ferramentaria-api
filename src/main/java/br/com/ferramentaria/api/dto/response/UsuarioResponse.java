package br.com.ferramentaria.api.dto.response;

import java.util.List;
import java.util.stream.Collectors;

import br.com.ferramentaria.api.entity.Usuario;
import br.com.ferramentaria.api.entity.enums.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioResponse {
	
    private Long idUsuario;
    private String nome;
    private String email;	
    private Status status;
    
    public UsuarioResponse() {};
    
    public UsuarioResponse(Usuario usuario) {
    	this.idUsuario = usuario.getIdUsuario();
    	this.nome = usuario.getNome();
    	this.email = usuario.getEmail();
    	this.status = usuario.getStatus();
    }
       
	public Long getId() {
		return idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}
	
	public Status getStatus() {
		return status;
	}

	public static List<UsuarioResponse> converter(List<Usuario> usuarios) {
		return usuarios.stream().map(UsuarioResponse::new).collect(Collectors.toList());
	}

}
