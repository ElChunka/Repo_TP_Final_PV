package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Receta;

public interface IRecetaService {
	
	List<Receta> getRecetas();
	List<Receta> getRecetaCategoria(String categoria);
	Receta getBy(Long id);
	Receta getReceta();
	void guardar(Receta receta);
}
