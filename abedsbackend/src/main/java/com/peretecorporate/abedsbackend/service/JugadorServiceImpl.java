package com.peretecorporate.abedsbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peretecorporate.abedsbackend.model.Jugador;
import com.peretecorporate.abedsbackend.repository.IJugadorRepository;

@Service
public class JugadorServiceImpl implements JugadorService{

	@Autowired
	private IJugadorRepository jugadorRepository;

	@Override
	public List<Jugador> findAll() {
		return jugadorRepository.findAll();
	}

	@Override
	public List<Jugador> findAllByidEquipo(Integer idEquipo) {		
		return jugadorRepository.findAllByidEquipo(idEquipo);
	}

	@Override
	public List<Jugador> findAllByidCategoria(Integer idCategoria) {
		return jugadorRepository.findAllByidCategoria(idCategoria);
	}

	@Override
	public List<Jugador> findAllByidEstado(Integer idEstado) {	
		return jugadorRepository.findAllByidEstado(idEstado);
	}

	@Override
	public Jugador getJugadorByidJugador(Integer id) {
		return jugadorRepository.getJugadorByidJugador(id);
	}

	@Override
	public void save(Jugador jugador) {
		jugadorRepository.save(jugador);
		
	}

	@Override
	public void deleteByidJugador(Integer idJugador) {
		jugadorRepository.deleteById(idJugador);
		
	}

	@Override
	public void delete(Jugador jugador) {
		jugadorRepository.delete(jugador);
	}
}
