package ar.edu.unju.fi.service;



import ar.edu.unju.fi.entity.Usuario;

public interface IUsuarioService {
	
	// List<Usuario> getUsuarios(); posiblemte necesitemos en un futuro
	public Usuario buscarUsuario(int codigo_buscar);

	void guardar(Usuario usuario);
	boolean verificarCodigoUsuario(int codigoUsuario);
	public Usuario buscarUsuarioId(Long usuarioId);
	public Usuario obtenerUsuarioPorCodigo(int codigoUsuario);

	Usuario getUsuario();

}
