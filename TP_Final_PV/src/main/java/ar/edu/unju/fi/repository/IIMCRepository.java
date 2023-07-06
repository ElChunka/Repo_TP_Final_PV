package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.IndiceMasaCorporal;

@Repository
public interface IIMCRepository extends CrudRepository<IndiceMasaCorporal, Long> {

	public List<IndiceMasaCorporal> findByUsuario(String usuario);
	
}
