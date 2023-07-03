package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
	public Usuario getByCodigo(int codigo);
}