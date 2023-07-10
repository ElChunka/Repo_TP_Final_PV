package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.IndiceMasaCorporal;

public interface IImcService {
	
	List<IndiceMasaCorporal> listarImcPorUsuario(Long usuarioId);
	void calcularIMC(Double peso);

}
