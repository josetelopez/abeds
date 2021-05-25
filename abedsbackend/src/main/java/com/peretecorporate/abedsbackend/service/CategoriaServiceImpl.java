package com.peretecorporate.abedsbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peretecorporate.abedsbackend.model.Categoria;
import com.peretecorporate.abedsbackend.repository.ICategoriaRepository;

@Service
public class CategoriaServiceImpl implements ICategoriaService {

	@Autowired
	private ICategoriaRepository categoriaRepository;

	@Override
	public List<Categoria> findAllCategorias() {

		return categoriaRepository.findAllCategorias();
	}

	@Override
	public Categoria getCategoriaByCodCategoria(String codCategoria) {

		return categoriaRepository.getCategoriaBycodCategoria(codCategoria);
	}

	@Override
	public List<String> getBynombre() {

		return categoriaRepository.getBynombre();
	}

	@Override
	public List<String> getBycodCategoria() {

		return categoriaRepository.findBycodCategoria();
	}

	@Override
	public void deleteByIdCategoria(Integer id) {

		categoriaRepository.deleteByIdCategoria(id);

	}

	@Override
	public void delete(Categoria categoria) {

		categoriaRepository.delete(categoria);

	}

	@Override
	public void save(Categoria categoria) {

		categoriaRepository.save(categoria);
	}

	@Override
	public int countNumeroCategorias() {

		return (int) categoriaRepository.count();
	}

}
