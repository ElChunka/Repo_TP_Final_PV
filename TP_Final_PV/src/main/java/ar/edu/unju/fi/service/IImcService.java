package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.IndiceMasaCorporal;

public interface IImcService {

	// Obtiene lista IMC (Indice de Masa Corporal) de un usuario por su ID.
	List<IndiceMasaCorporal> listarImcPorUsuario(Long usuarioId);

	//IMC (Indice de Masa Corporal)
	void calcularIMC(Double peso, int codigo);

}
