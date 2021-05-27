package com.peretecorporate.abedsbackend.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.peretecorporate.abedsbackend.model.Direccion;
import com.peretecorporate.abedsbackend.service.DireccionService;

@RestController
@RequestMapping("/v1/direccion")
public class DireccionRestController {

	private static final Logger	log	= LoggerFactory.getLogger(DireccionRestController.class);

	/** Servicio usuario */
	@Autowired
	DireccionService			direccionService;

	@RequestMapping(value = "/allDirecciones", method = RequestMethod.GET)
	public List<Direccion> findAll() {
		log.info("Inicio del metodo rest DireccionRestController>>findAll....");
		List<Direccion> direcciones = direccionService.findAll();
		log.info("Finaliza del metodo rest DireccionRestController>>findAll...");
		return direcciones;
	}

	@RequestMapping(value = "/findAllBycodPostal", method = RequestMethod.GET)
	public List<Direccion> findAllBycodPostal(int codPostal) {
		log.info("Inicio del metodo rest DireccionRestController>>findAllBycodPostal.... con parametro " + codPostal);
		List<Direccion> direcciones = direccionService.findAllBycodPostal(codPostal);
		log.info("Finaliza del metodo rest DireccionRestController>>findAllBycodPostal...");
		return direcciones;
	}

	@RequestMapping(value = "/findBymunicipio/{municipio}", method = RequestMethod.GET)
	public List<Direccion> findBymunicipio(@PathVariable("municipio") String municipio) {
		log.info("Inicio del metodo rest DireccionRestController>>findBymunicipio.... con parametro " + municipio);
		String muniUpperCase = municipio.toUpperCase();
		List<Direccion> direcciones = direccionService.findBymunicipio(muniUpperCase);
		log.info("Finaliza del metodo rest DireccionRestController>>findBymunicipio...");
		return direcciones;
	}

	@RequestMapping(value = "/findByidDireccion/{id}", method = RequestMethod.GET)
	public Direccion findByidDireccion(@PathVariable("id") Integer id) {
		log.info("Inicio del metodo rest DireccionRestController>>findByidDireccion.... con parametro " + id);
		Direccion direccion = direccionService.findByidDireccion(id);
		log.info("Finaliza del metodo rest DireccionRestController>>findByidDireccion...");
		return direccion;
	}

	@RequestMapping(value = "/findByidUsuario/{id}", method = RequestMethod.GET)
	public Direccion findByidUsuario(@PathVariable("id") Integer idUsuario) {
		log.info("Inicio del metodo rest DireccionRestController>>findByidUsuario.... con parametro " + idUsuario);
		Direccion direccion = direccionService.findByidUsuario(idUsuario);
		log.info("Finaliza del metodo rest DireccionRestController>>findByidUsuario...");
		return direccion;
	}

	@RequestMapping(value = "/findAllBymunicipio", method = RequestMethod.GET)
	public List<String> findAllBymunicipio() {
		log.info("Inicio del metodo rest DireccionRestController>>findAllBymunicipio....");
		List<String> municipios = direccionService.findAllBymunicipio();
		log.info("Finaliza del metodo rest DireccionRestController>>findAllBymunicipio...");
		return municipios;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public void delete(Direccion direccion) {
		log.info("Inicio del metodo rest DireccionRestController>>delete....");
		direccionService.delete(direccion);
		log.info("Finaliza del metodo rest DireccionRestController>>delete...");
	}

	@RequestMapping(value = "/deleteById/{id}", method = RequestMethod.POST)
	public void deleteById(@PathVariable("id") Integer idDireccion) {
		log.info("Inicio del metodo rest DireccionRestController>>deleteById.... con parametro " + idDireccion);
		direccionService.deleteByid(idDireccion);
		log.info("Finaliza del metodo rest DireccionRestController>>deleteById...");
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public void save(Direccion direccion) {
		log.info("Inicio del metodo rest DireccionRestController>>save....");
		direccionService.save(direccion);
		log.info("Finaliza del metodo rest DireccionRestController>>save...");
	}
}
