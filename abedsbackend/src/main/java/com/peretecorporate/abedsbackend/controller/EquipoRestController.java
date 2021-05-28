package com.peretecorporate.abedsbackend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.peretecorporate.abedsbackend.service.EquipoService;

@RestController
@RequestMapping("/v1/equipo")
public class EquipoRestController {
	
	private static final Logger log = LoggerFactory.getLogger(EquipoRestController.class);

	/** Servicio equipo */
	@Autowired
	EquipoService equipoService;

}
