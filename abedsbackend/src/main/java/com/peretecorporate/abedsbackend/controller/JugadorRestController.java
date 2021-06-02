package com.peretecorporate.abedsbackend.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.peretecorporate.abedsbackend.model.Jugador;
import com.peretecorporate.abedsbackend.service.JugadorService;

@RestController
@RequestMapping("/v1/jugador")
public class JugadorRestController {

	private static final Logger log = LoggerFactory.getLogger(JugadorRestController.class);

	/** Servicio jugador */
	@Autowired
	JugadorService jugadorService;

	@RequestMapping(value = "/allJugadores", method = RequestMethod.GET)
	public List<Jugador> findAll() {

		log.info("Inicio del metodo rest JugadorRestController>>findAllJugadores....");
		List<Jugador> jugadorList = jugadorService.findAll();
		log.info("Finaliza del metodo rest JugadorRestController>>findAllJugadores...");

		return jugadorList;
	}

	@RequestMapping(value = "/findAllByidEquipo/{idEquipo}", method = RequestMethod.GET)
	public List<Jugador> findAllByidEquipo(@PathVariable("idEquipo") Integer idEquipo) {

		log.info("Inicio del metodo rest JugadorRestController>>findAllByidEquipo.... con parametro " + idEquipo);
		List<Jugador> jugadorListEquipo = jugadorService.findAllByequipo(idEquipo);
		log.info("Finaliza del metodo rest JugadorRestController>>findAllByidEquipo...");

		return jugadorListEquipo;
	}

	@RequestMapping(value = "/findAllByidCategoria/{idCategoria}", method = RequestMethod.GET)
	public List<Jugador> findAllByidCategoria(@PathVariable("idCategoria") Integer idCategoria) {

		log.info("Inicio del metodo rest JugadorRestController>>findAllByidCategoria.... con parametro " + idCategoria);
		List<Jugador> jugadorListCategoria = jugadorService.findAllByidCategoria(idCategoria);
		log.info("Finaliza del metodo rest JugadorRestController>>findAllByidCategoria...");

		return jugadorListCategoria;
	}

	@RequestMapping(value = "/findAllByidEstado/{idEstado}", method = RequestMethod.GET)
	public List<Jugador> findAllByidEstado(@PathVariable("idEstado") Integer idEstado) {

		log.info("Inicio del metodo rest JugadorRestController>>findAllByidEstado.... con parametro " + idEstado);
		List<Jugador> jugadorListEstado = jugadorService.findAllByidEstado(idEstado);
		log.info("Finaliza del metodo rest JugadorRestController>>findAllByidEstado...");

		return jugadorListEstado;
	}

	@RequestMapping(value = "/getJugadorByidJugador/{id}", method = RequestMethod.GET)
	public Jugador getJugadorByidJugador(@PathVariable("id") Integer id) {

		log.info("Inicio del metodo rest JugadorRestController>>getJugadorByidJugador.... con parametro " + id);
		Jugador jugador = jugadorService.getJugadorByidJugador(id);
		log.info("Finaliza del metodo rest JugadorRestController>>getJugadorByidJugador...");

		return jugador;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public void save(Jugador jugador) {
		log.info("Inicio del metodo rest JugadorRestController>>save....");
		jugadorService.save(jugador);
		log.info("Finaliza del metodo rest JugadorRestController>>save...");

	}

	@RequestMapping(value = "/deleteByidJugador/{idJugador}", method = RequestMethod.POST)
	public void deleteByidJugador(@PathVariable("idJugador") Integer idJugador) {

		log.info("Inicio del metodo rest JugadorRestController>>deleteByidJugador.... con parametro " + idJugador);
		jugadorService.deleteByidJugador(idJugador);
		log.info("Finaliza del metodo rest JugadorRestController>>deleteByidJugador...");

	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public void delete(Jugador jugador) {

		log.info("Inicio del metodo rest JugadorRestController>>delete....");
		jugadorService.delete(jugador);
		log.info("Finaliza del metodo rest JugadorRestController>>delete...");
	}
}
