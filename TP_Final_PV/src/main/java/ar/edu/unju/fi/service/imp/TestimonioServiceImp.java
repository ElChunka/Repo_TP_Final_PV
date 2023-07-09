package ar.edu.unju.fi.service.imp;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Testimonio;

import ar.edu.unju.fi.repository.ITestimonioRepository;

import ar.edu.unju.fi.service.ITestimonioService;

@Service("TestimonioServiceImp")
public class TestimonioServiceImp implements ITestimonioService {

	//
	@Autowired
    private ITestimonioRepository testimonioRepository;

	// Guarda un testimonio que setea por defecto la fecha actual de la maquina
    @Override
    public Testimonio guardarTestimonio(Testimonio testimonio) {
    	testimonio.setFecha(LocalDate.now());
        return testimonioRepository.save(testimonio);
    }

    //Actualiza un testimonio que setea por defecto la fecha actual de la maquina
    @Override
    public Testimonio actualizarTestimonio(Testimonio testimonio) {
    	testimonio.setFecha(LocalDate.now());
        return testimonioRepository.save(testimonio);
    }

    //Elimina un testimonio por su ID.
    @Override
    public void eliminarTestimonio(Long id) {
        testimonioRepository.deleteById(id);
    }

    //Busca un testimonio por su ID.
    @Override
    public Testimonio buscarPorId(Long id) {
        Optional<Testimonio> testimonioOptional = testimonioRepository.findById(id);
        return testimonioOptional.orElse(null);
    }

    //Obtiene una lista de todos los testimonios.
    @Override
    public List<Testimonio> listarTestimonios() {
        return testimonioRepository.findAll();
    }
    
    //Obtiene una lista de testimonios asociados a un usuario por su ID.
    @Override
    public List<Testimonio> listarTestimoniosPorUsuario(Long usuarioId) {
        return testimonioRepository.findByUsuarioId(usuarioId);
    }

	
}