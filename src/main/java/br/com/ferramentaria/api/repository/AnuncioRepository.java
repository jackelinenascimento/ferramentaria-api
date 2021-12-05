package br.com.ferramentaria.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ferramentaria.api.entity.Anuncio;

public interface AnuncioRepository extends JpaRepository<Anuncio, Long> {

}