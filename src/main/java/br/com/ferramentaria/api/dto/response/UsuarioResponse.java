package br.com.ferramentaria.api.dto.response;

import java.util.List;
import java.util.stream.Collectors;

import br.com.ferramentaria.api.entity.Endereco;
import br.com.ferramentaria.api.entity.Telefone;
import br.com.ferramentaria.api.entity.Usuario;
import br.com.ferramentaria.api.entity.enums.Status;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UsuarioResponse {
	
    private Long idUsuario;
    private String nome;
    private String email;	
    private Status status;
    private Endereco endereco;
    private Telefone telefone;
    
    public UsuarioResponse(Usuario usuario) {
    	this.idUsuario = usuario.getIdUsuario();
    	this.nome = usuario.getNome();
    	this.email = usuario.getEmail();
    	this.status = usuario.getStatus();
    	this.endereco = usuario.getEndereco();
    	this.telefone = usuario.getTelefone();
    }

	public static List<UsuarioResponse> converter(List<Usuario> usuarios) {
		return usuarios.stream().map(UsuarioResponse::new).collect(Collectors.toList());
	}

}
