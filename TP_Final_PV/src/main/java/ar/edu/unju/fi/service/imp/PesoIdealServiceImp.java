package ar.edu.unju.fi.service.imp;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unju.fi.entity.Usuario;

public class PesoIdealServiceImp {
	double pesoideal;
	
	@Autowired
	Usuario usuario;
	 
	public void CalcularPesoIdeal(int edad) {
		
		pesoideal =  usuario.getEstatura() - 100 +((edad/10)*0.9);
	}


}
