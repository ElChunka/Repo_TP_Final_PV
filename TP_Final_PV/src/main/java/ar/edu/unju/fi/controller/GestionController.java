package ar.edu.unju.fi.controller;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.entity.Testimonio;
import ar.edu.unju.fi.service.IUsuarioService;

import ar.edu.unju.fi.service.ITestimonioService;


@Controller
@RequestMapping("/gestion")
public class GestionController {
	
	@Autowired
    private IUsuarioService usuarioService;
	
	
    @Autowired	
    private ITestimonioService testimonioService;
    
    
    //Maneja la solicitud GET para la página de gestión de datos y muestra la plantilla
    @GetMapping("/datos")
    public String mostrarFormularioCodigo(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "gestion_datos";
    }
    
    
    
    
    
    
   
    

    @PostMapping("/verificar-codigo")
    public String verificarCodigoUsuario(@RequestParam("codigoUsuario") int codigoUsuario, Model model) {
    	 // Buscar el usuario en función del código de usuario proporcionado
    	Usuario usuario = usuarioService.buscarUsuario(codigoUsuario);
        if (usuario.getCodigo() == 9999 || usuario.getCodigo()==7777) {
        	// Si se encuentra un usuario válido:
            // Establecer los atributos en el modelo
            model.addAttribute("usuarioValido", true);
            model.addAttribute("usuario", usuario);
            
            // Obtener los testimonios del usuario y pasarlos al modelo
            List<Testimonio> testimonios = testimonioService.listarTestimonios();
            testimonios.sort(Comparator.comparing(Testimonio::getFecha)); // Orden ascendente
            Collections.reverse(testimonios); // Invertir el orden para obtener descendente
            model.addAttribute("testimonios", testimonios);
        } else {
        	
        	// Si no se encuentra un usuario válido:
            // Establecer el atributo en el modelo indicando que el usuario no es válido
            model.addAttribute("usuarioValido", false);
        }
     // Devolver el nombre de la vista para la página de gestión de datos
        return "gestion_datos";
    }

   
    
	
}
