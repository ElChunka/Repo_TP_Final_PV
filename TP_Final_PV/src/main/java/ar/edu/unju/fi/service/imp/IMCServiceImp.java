package ar.edu.unju.fi.service.imp;

import java.util.Date;
import java.util.List;
//import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.IndiceMasaCorporal;
import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.repository.IIMCRepository;
/*@Service
public class IMCServiceImp {

	@Autowired
	private IIMCRepository imcRepository;
	
	@Autowired
	Usuario usuario;
	
	public void CalcularIMC(Double peso) {
    	// Obtenga el peso y la altura del usuario.
        
       IndiceMasaCorporal imc_usuario = new IndiceMasaCorporal();
       
        // Calcular el Indice de Masa Corporal
        double imc = peso / (usuario.getEstatura() * usuario.getEstatura());// Falta crear usuario para calcular el imc el peso con la altura
        // Display a message based on the BMI result.
        if (imc < 18.5) {
        	imc_usuario.setEstado("Su IMC es " + imc + " - Está por debajo de su peso ideal");
        } else if (imc >= 18.5 && imc <= 25) {
        	imc_usuario.setEstado("Su IMC es " + imc + " - Está en su peso normal.");
        } else {
        	imc_usuario.setEstado("Su IMC es " + imc + " - Tiene sobrepeso.");
        }
        imc_usuario.setFehca_imc(new Date());
        imc_usuario.setUsuario(usuario.getNombre());// Falta crear usuario para asignar nombre
        imcRepository.save(imc_usuario);
    }
	
	public List<IndiceMasaCorporal> AllByUsuario() {
		return imcRepository.findByusuario(usuario.getNombre());// Falta usuario para devolver los imc
	}
	
	
}*/
