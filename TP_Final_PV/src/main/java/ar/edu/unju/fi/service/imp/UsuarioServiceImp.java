package ar.edu.unju.fi.service.imp;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.repository.IUsuarioRepository;
import ar.edu.unju.fi.service.IUsuarioService;

@Service
public class UsuarioServiceImp implements IUsuarioService {

	
	@Autowired
	private IUsuarioRepository usuarioRepository;
	
	@Autowired
	private Usuario usuario;
	
	/*@Override			//posiblemte mas tarde
	public List<Usuario> getUsuarios() {
		return usuarioRepository.findAll();
	}*/

	@Override
	public void Guardar(Usuario usuario) {
		boolean unico;
		Random random = new Random();
		int Codigo_generado; 
		
		do
		{
			Codigo_generado = random.nextInt(9000) + 1000;
			unico = true;
			for( Usuario user : usuarioRepository.findAll())
			{
				if(user.getCodigo() == Codigo_generado)
					unico = false;
			}
		}while(unico == false);
		
		usuario.setCodigo(Codigo_generado);
		usuarioRepository.save(usuario);
	}

	@Override
	public Usuario buscarUsuario(int codigo_buscar) {
		usuario = usuarioRepository.getByCodigo(codigo_buscar);
		return usuario;
	}
	
	
}
