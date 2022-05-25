package br.com.ferramentaria.api.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.ferramentaria.api.entity.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity	
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mensagem {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMensagem;
	
	private LocalDateTime data = LocalDateTime.now();
	
	@Enumerated(EnumType.STRING)
	private Status status = Status.ATIVO;
	
	private String mensagem;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	private Conversa idConversa;
	
}
