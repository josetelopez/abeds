package com.peretecorporate.abedsbackend.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.peretecorporate.abedsbackend.model.Estado;
import com.peretecorporate.abedsbackend.service.EstadoService;

@RestController
@RequestMapping("/v1/estado")
public class EstadoRestController {

	private static final Logger	log	= LoggerFactory.getLogger(EstadoRestController.class);

	@Autowired
	EstadoService				estadoService;

	@RequestMapping(value = "/allEstados", method = RequestMethod.GET)
	List<Estado> getEstadosList() {

		log.info("Inicio del metodo rest EstadoRestController>>getEstadosList....");

		List<Estado> estadoList = estadoService.findAll();

		log.info("Finaliza del metodo rest EstadoRestController>>getEstadosList...");

		return estadoList;
	}

	@RequestMapping(value = "/estadoByCodEstado/{codestado}/", method = RequestMethod.GET)
	Estado getEstadoByCodEstado(@PathVariable("codestado") int codestado) {

		log.info("Inicio del metodo rest EstadoRestController>>getEstado.... con parametro " + codestado);

		Estado estado = estadoService.getEstadoBycodEstado(codestado);

		log.info("Finaliza del metodo rest EstadoRestController>>getEstado...");

		return estado;
	}

	@RequestMapping(value = "/estadoByNombreEstado/{nombreEstado}/", method = RequestMethod.GET)
	Estado getEstadoBynombreEstado(@PathVariable("nombreEstado") String nombreEstado) {

		log.info("Inicio del metodo rest EstadoRestController>>getEstadoBynombreEstado.... con parametro "
					+ nombreEstado);

		Estado estado = estadoService.getEstadoBynombreEstado(nombreEstado);

		log.info("Finaliza del metodo rest EstadoRestController>>getEstadoBynombreEstado...");

		return estado;
	}

	@RequestMapping(value = "/allNombreEstados", method = RequestMethod.GET)
	List<String> getNombreEstados() {

		log.info("Inicio del metodo rest EstadoRestController>>getEstadoBynombreEstado....");

		List<String> nombreEstadoList = estadoService.getnombreEstados();

		log.info("Finaliza del metodo rest EstadoRestController>>getEstadoBynombreEstado...");

		return nombreEstadoList;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	void delete(Estado estado) {
		estadoService.delete(estado);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	void save(Estado estado) {
		estadoService.save(estado);
	}

}
