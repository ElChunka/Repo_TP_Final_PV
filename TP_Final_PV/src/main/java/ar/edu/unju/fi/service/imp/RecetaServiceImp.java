package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Receta;
import ar.edu.unju.fi.repository.IRecetaRepository;
import ar.edu.unju.fi.service.IRecetaService;

@Service("recetaServiceMysql")
public class RecetaServiceImp implements IRecetaService {
	
	@Autowired
	IRecetaRepository recetaRepository;
	
	@Autowired
	Receta receta;
	
	@Override
	public List<Receta> getRecetas() {
		return recetaRepository.findAll();
	}

	@Override
	public Receta getReceta() {
		return receta;
	}

	@Override
	public void guardar(Receta receta) {
		recetaRepository.save(receta);
	}

	@Override
	public List<Receta> getRecetaCategoria(String categoria) {
		return recetaRepository.findByCategoria(categoria);
	}

	@Override
	public Receta getBy(Long id) {
		return recetaRepository.findById(id).get();
	}

}
