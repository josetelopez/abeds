package com.peretecorporate.abedsbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peretecorporate.abedsbackend.model.Direccion;
import com.peretecorporate.abedsbackend.repository.IDireccionRepository;

@Service
public class DireccionServiceImpl implements DireccionService {

	@Autowired
	private IDireccionRepository direccionRepository;

	@Override
	public List<Direccion> findAll() {

		return direccionRepository.findAll();
	}

	@Override
	public List<Direccion> findAllBycodPostal(int codPostal) {

		return direccionRepository.findAllBycodPostal(codPostal);
	}

	@Override
	public List<Direccion> findBymunicipio(String municipio) {

		return direccionRepository.findBymunicipio(municipio);
	}

	@Override
	public Direccion findByidDireccion(Integer id) {

		return direccionRepository.findByidDireccion(id);
	}

	@Override
	public Direccion findByidUsuario(Integer idUsuario) {

		return direccionRepository.findByidUsuario(idUsuario);
	}

	@Override
	public List<String> findAllBymunicipio() {

		return direccionRepository.findAllBymunicipio();
	}

	@Override
	public void delete(Direccion direccion) {
		direccionRepository.delete(direccion);
	}

	@Override
	public void deleteByid(Integer idDireccion) {
		direccionRepository.deleteById(idDireccion);
	}

	@Override
	public void save(Direccion direccion) {
		direccionRepository.save(direccion);
	}

}
