package com.peretecorporate.abedsbackend.service;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.peretecorporate.abedsbackend.model.Categoria;

@Service
public interface ICategoriaService {

	List<Categoria> findAllCategorias();

	Categoria getCategoriaByCodCategoria(@Param("cod_categoria") String codCategoria);

	List<String> getBynombre();

	List<String> getBycodCategoria();

	void deleteByIdCategoria(@Param("id") Integer id);

	void delete(Categoria categoria);
	
	void save(Categoria categoria);
	
	int countNumeroCategorias();
}
