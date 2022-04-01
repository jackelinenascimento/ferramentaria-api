package br.com.ferramentaria.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ferramentaria.api.entity.Mensagem;

public interface MensagemRepository extends JpaRepository<Mensagem, Long>{

}
