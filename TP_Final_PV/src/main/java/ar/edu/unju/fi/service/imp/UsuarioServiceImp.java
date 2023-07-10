package ar.edu.unju.fi.service.imp;


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

    @Override
    public void guardar(Usuario usuario) {
        generarYAsignarCodigo(usuario);
        usuarioRepository.save(usuario);
    }

    private void generarYAsignarCodigo(Usuario usuario) {
        boolean unico = false;
        Random random = new Random();
        int codigoGenerado;

        do {
            codigoGenerado = random.nextInt(9000) + 1000;
            Usuario usuarioExistente = usuarioRepository.findByCodigo(codigoGenerado);
            if (usuarioExistente == null) {
                unico = true;
            }
        } while (!unico);

        usuario.setCodigo(codigoGenerado);
    }

    @Override
    public Usuario buscarUsuario(int codigo_buscar) {
        return usuarioRepository.findByCodigo(codigo_buscar);
    }
    
    @Override
	public boolean verificarCodigoUsuario(int codigoUsuario) {
		Usuario usuario = buscarUsuario(codigoUsuario);
		return usuario != null;
	}

    @Override
    public Usuario buscarUsuarioId(Long usuarioId) {
        return usuarioRepository.findById(usuarioId).orElse(null);
    }

	@Override
	public Usuario obtenerUsuarioPorCodigo(int codigoUsuario) {
	    return usuarioRepository.findByCodigo(codigoUsuario);
	}


	@Override
	public Usuario getUsuario() {
		return null;
	}


	@Override
	public Usuario getUltimoUsuario() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario getUsuarioFinal() {
		return usuarioRepository.findUltimoDato();
	}	
}
