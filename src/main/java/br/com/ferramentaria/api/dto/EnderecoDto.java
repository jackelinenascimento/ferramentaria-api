package br.com.ferramentaria.api.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import br.com.ferramentaria.api.entity.Endereco;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDto {
	
	@NotEmpty
	private String logradouro;
    
	private String complemento;
    
	@NotEmpty
	private String bairro;
    
	@NotEmpty
	private String cidade;
    
	@NotEmpty
	@Size(min=2, max=2)
	private String uf;
    
	@NotEmpty
	@Size(min=8, max=8)
	private String cep;

	public static Endereco toModel(EnderecoDto enderecoDto) {
		return new Endereco(enderecoDto.getLogradouro(),
							enderecoDto.getComplemento(),
							enderecoDto.getBairro(),
							enderecoDto.getCidade(),
							enderecoDto.getUf(),
							enderecoDto.getCep());
	}

}
