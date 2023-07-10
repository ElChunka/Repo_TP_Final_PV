package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import ar.edu.unju.fi.entity.IndiceMasaCorporal;
import ar.edu.unju.fi.entity.Usuario;

@Repository
public interface IIMCRepository extends JpaRepository<IndiceMasaCorporal, Long> {



	List<IndiceMasaCorporal> findByUsuarioId(Long usuarioId);
	
	
}
