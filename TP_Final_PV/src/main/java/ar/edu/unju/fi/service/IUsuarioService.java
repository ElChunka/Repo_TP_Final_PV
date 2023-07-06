package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Usuario;

public interface IUsuarioService {
	
	// List<Usuario> getUsuarios(); posiblemte necesitemos en un futuro
	public Usuario buscarUsuario(int codigo_buscar);
	void Guardar(Usuario usuario);
	Usuario getUsuario();
}
