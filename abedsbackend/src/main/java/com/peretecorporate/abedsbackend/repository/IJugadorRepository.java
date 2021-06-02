package com.peretecorporate.abedsbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.peretecorporate.abedsbackend.model.Jugador;

public interface IJugadorRepository extends JpaRepository<Jugador, Integer> {
	
	
	List<Jugador> findAll();
	
	List<Jugador> findAllByequipo(Integer idEquipo);
	
	List<Jugador> findAllBycategoria(Integer idCategoria);
	
	List<Jugador> findAllByestado(Integer idEstado);
	
	Jugador getJugadorByidJugador(Integer id);
	
	
}
