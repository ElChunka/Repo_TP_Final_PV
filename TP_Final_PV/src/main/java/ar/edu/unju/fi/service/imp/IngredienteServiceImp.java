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
	Ingrediente ingrediente;
	
	@Autowired
	IIngredienteRepository ingredienteRepository; 
	
	@Override
	public List<Ingrediente> getIngredientes() { //devuelve etodos los ingredientes
		return ingredienteRepository.findAll();
	}

	@Override
	public Ingrediente getIngrediente() {
		return ingrediente;
	}

	@Override
	public void guardar(Ingrediente ingrediente) {  //guarda ingredientes
		ingredienteRepository.save(ingrediente);
	}
}
