package com.peretecorporate.abedsbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peretecorporate.abedsbackend.repository.IDireccionRepository;

@Service
public class DireccionService {

	@Autowired
	private IDireccionRepository direccionRepository;

	
}
