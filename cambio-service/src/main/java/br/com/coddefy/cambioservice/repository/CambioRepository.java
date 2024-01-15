package br.com.coddefy.cambioservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.coddefy.cambioservice.model.Cambio;

public interface CambioRepository extends JpaRepository<Cambio, Long>{
	Cambio findByFromAndTo(String from, String to);
}
