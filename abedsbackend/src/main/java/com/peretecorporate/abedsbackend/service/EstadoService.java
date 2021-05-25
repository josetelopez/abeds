package com.peretecorporate.abedsbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peretecorporate.abedsbackend.repository.IEstadoRepository;

@Service
public class EstadoService {

	@Autowired
	private IEstadoRepository estadoRepository;
}
