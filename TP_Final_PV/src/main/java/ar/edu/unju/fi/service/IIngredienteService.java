package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Ingrediente;

public interface IIngredienteService {
	List<Ingrediente> getIngredientes();
	Ingrediente getIngrediente();
	void guardar(Ingrediente ingrediente);
}
