package ar.edu.unju.fi.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import ar.edu.unju.fi.entity.Testimonio;

@Repository
public interface ITestimonioRepository extends JpaRepository<Testimonio, Long> {
	//Busca testimonios por ID de usuario.
	List<Testimonio> findByUsuarioId(Long usuarioId);
	
}
