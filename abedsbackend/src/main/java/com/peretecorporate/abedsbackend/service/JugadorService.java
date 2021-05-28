package com.peretecorporate.abedsbackend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.peretecorporate.abedsbackend.model.Jugador;

@Service
public interface JugadorService {

	List<Jugador> findAll();

	List<Jugador> findAllByidEquipo(Integer idEquipo);

	List<Jugador> findAllByidCategoria(Integer idCategoria);

	List<Jugador> findAllByidEstado(Integer idEstado);

	Jugador getJugadorByidJugador(Integer id);
	
	void save(Jugador jugador);
	
	void deleteByidJugador(Integer idJugador);

	void delete(Jugador jugador);
}
