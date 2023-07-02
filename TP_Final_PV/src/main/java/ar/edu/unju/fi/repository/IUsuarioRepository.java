package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.entity.Usuario;

public interface IUsuarioRepository extends CrudRepository<Usuario, Long> {
	public List<Usuario> findByEstado(boolean estado);
}
