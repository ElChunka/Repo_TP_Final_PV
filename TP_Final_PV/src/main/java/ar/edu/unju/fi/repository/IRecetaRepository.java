package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.Receta;

@Repository
public interface IRecetaRepository extends JpaRepository<Receta, Long>{
	public List<Receta> findByCategoria(String categoria);
}
