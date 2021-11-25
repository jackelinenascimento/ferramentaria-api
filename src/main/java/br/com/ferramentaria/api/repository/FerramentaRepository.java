package br.com.ferramentaria.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ferramentaria.api.entity.Ferramenta;

public interface FerramentaRepository extends JpaRepository<Ferramenta, Long>{

}
