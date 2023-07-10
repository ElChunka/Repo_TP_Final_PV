package ar.edu.unju.fi.service.imp;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.IndiceMasaCorporal;
import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.repository.IIMCRepository;

import ar.edu.unju.fi.repository.IUsuarioRepository;
@Service
public class IMCServiceImp {

	@Autowired
	private IIMCRepository imcRepository;
	@Autowired 
	IUsuarioRepository usuRep;
	@Autowired
	Usuario usuario;

	//Calcula el IMC (Indice de Masa Corporal) segun la altura que se obtiene
	//de sus datos ingresados y el peso
	public void calcularIMC(Double peso, int codigo) {
    	// Obtenga el IMC (Indice de Masa Corporal)
       Usuario usuario = usuRep.findByCodigo(codigo);
       IndiceMasaCorporal imc_usuario = new IndiceMasaCorporal();
       DecimalFormat formato = new DecimalFormat("#.#");
       String imcFormateado;
        // Calcular el Indice de Masa Corporal
        double imc = peso / (usuario.getEstatura() * usuario.getEstatura());
        imcFormateado = formato.format(imc);
        // Display a message based on the BMI result.
        if (imc < 18.5) {
        	imc_usuario.setEstado("Su IMC es " + imcFormateado + " - Está por debajo de su peso ideal");
        } else if (imc >= 18.5 && imc <= 25) {
        	imc_usuario.setEstado("Su IMC es  " + imcFormateado + " - Está en su peso normal.");
        } else {
        	imc_usuario.setEstado("Su IMC es " + imcFormateado + " - Tiene sobrepeso.");
        }
        imc_usuario.setFecha_imc(LocalDate.now());
        imc_usuario.setUsuario(usuario);
        imcRepository.save(imc_usuario);
    }

	//Obtiene una lista IMC (Indice de Masa Corporal) de un usuario por su ID.
	public List<IndiceMasaCorporal> AllByUsuario(Long usuarioId) {

		return imcRepository.findByUsuarioId(usuarioId);
	}

	/*public List<IndiceMasaCorporal> getAllIndices()  {
		List<IndiceMasaCorporal> indiceMasa = new ArrayList<>();
	    Usuario usuario = this.usuRep.findUltimoDato();
		indiceMasa = this.imcRepository.findByUsuarioId(usuarioId);
		return indiceMasa;
	}*/
}
