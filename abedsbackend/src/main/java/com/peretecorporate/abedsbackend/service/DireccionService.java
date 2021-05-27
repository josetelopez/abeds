package com.peretecorporate.abedsbackend.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.peretecorporate.abedsbackend.model.Direccion;

@Service
public interface DireccionService {

	List<Direccion> findAll();

	List<Direccion> findAllBycodPostal(int codPostal);

	List<Direccion> findBymunicipio(String municipio);

	Direccion findByidDireccion(Integer id);

	Direccion findByidUsuario(Integer idUsuario);

	List<String> findAllBymunicipio();

	void delete(Direccion direccion);

	void deleteByid(Integer idDireccion);

	void save(Direccion direccion);

}
