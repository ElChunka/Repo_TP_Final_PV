package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Testimonio;

public interface ITestimonioService {
	
	//Guarda un testimonio
	Testimonio guardarTestimonio(Testimonio testimonio);
    
	//Actualiza un testimonio.
	Testimonio actualizarTestimonio(Testimonio testimonio);
    
	// Elimina un testimonio por su ID.
	void eliminarTestimonio(Long id);
    
	//Busca un testimonio por su ID.
	Testimonio buscarPorId(Long id);
    
	//Obtiene una lista de todos los testimonios.
	List<Testimonio> listarTestimonios();
	
	// Obtiene una lista de testimonios asociados a un usuario por su ID.
	List<Testimonio> listarTestimoniosPorUsuario(Long usuarioId);
	
	
	
}