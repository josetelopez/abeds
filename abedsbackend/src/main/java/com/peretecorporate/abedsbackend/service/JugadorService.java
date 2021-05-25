package com.peretecorporate.abedsbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peretecorporate.abedsbackend.repository.IJugadorRepository;

@Service
public class JugadorService {

	@Autowired
	private IJugadorRepository jugadorRepository;
}
