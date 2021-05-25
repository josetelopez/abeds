package com.peretecorporate.abedsbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peretecorporate.abedsbackend.repository.IEquipoRepository;

@Service
public class EquipoService {

	@Autowired
	private IEquipoRepository equipoRepository;
}
