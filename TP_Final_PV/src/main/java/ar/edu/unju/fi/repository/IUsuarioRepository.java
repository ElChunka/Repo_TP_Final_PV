package ar.edu.unju.fi.repository;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.Usuario;


@Repository
public interface IUsuarioRepository extends CrudRepository<Usuario, Long> {
    boolean existsByCodigo(int codigo);
    Usuario findByCodigo(int codigo);
	
	@Query(value = "SELECT * FROM usuarios u ORDER BY u.user_id DESC limit 1", nativeQuery = true)
	 public Usuario findUltimoDato(); 
}