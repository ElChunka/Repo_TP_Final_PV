package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Ingrediente;
import ar.edu.unju.fi.repository.IIngredienteRepository;
import ar.edu.unju.fi.service.IIngredienteService;

@Service
public class IngredienteServiceImp implements IIngredienteService {

	@Autowired
	IIngredienteRepository ingredienteRepository; 
	
	@Override
	public List<Ingrediente> getIngredientes() {
		return ingredienteRepository.findAll();
	}
}
