package ar.edu.unju.fi.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//import ar.edu.unju.fi.entity.IMC;
import ar.edu.unju.fi.entity.IndiceMasaCorporal;
import ar.edu.unju.fi.entity.Testimonio;
import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.service.IUsuarioService;
import ar.edu.unju.fi.service.imp.IMCServiceImp;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/servicios")
public class ServicioController {

	@Autowired
    private IUsuarioService usuarioService;
	
	@Autowired
	IMCServiceImp imcService;
	
    @GetMapping("/imc")
    public String getImcPage() {
        return "mostrar_imc";
    }
    
    
    
    @PostMapping("/guardar")
    public ModelAndView getGuardarNuevoImcPage(@RequestParam("peso") Double peso, @RequestParam("codigo") int codigo, Model model) {
    	ModelAndView modelView = new ModelAndView("mostrar_imc");
    	imcService.calcularIMC(peso, codigo);
    	return modelView;
    }
    
    
    /*@GetMapping("/indiceMasa")
    public List<IndiceMasaCorporal> getAllImcList(Model model) {
    	System.out.println("aaa");
    	List<IndiceMasaCorporal> indiceMasa = new ArrayList<>();
    	indiceMasa = this.imcService.getAllIndices();
        model.addAttribute("in", indiceMasa);
    	return indiceMasa;
    }*/
    
    @PostMapping("/verificar-codigo")
    public String verificarCodigoUsuario(@RequestParam("codigoUsuario") int codigoUsuario, Model model) {
    	 // Buscar el usuario en función del código de usuario proporcionado
    	Usuario usuario = usuarioService.buscarUsuario(codigoUsuario);
        if (usuario != null) {
        	// Si se encuentra un usuario válido:
            // Establecer los atributos en el modelo
            model.addAttribute("usuarioValido", true);
            model.addAttribute("usuario", usuario);
            
            // Obtener los testimonios del usuario y pasarlos al modelo
            List<IndiceMasaCorporal> listaIndiceMasaCorporal = imcService.AllByUsuario(usuario.getId());
            listaIndiceMasaCorporal.sort(Comparator.comparing(IndiceMasaCorporal::getFecha_imc)); // Orden ascendente
            Collections.reverse(listaIndiceMasaCorporal); // Invertir el orden para obtener descendente
            model.addAttribute("listaImc", listaIndiceMasaCorporal);
        } else {
        	
        	// Si no se encuentra un usuario válido:
            // Establecer el atributo en el modelo indicando que el usuario no es válido
            model.addAttribute("usuarioValido", false);
        }
     // Devolver el nombre de la vista para la página de gestión de datos
        return "mostrar_imc";
    }
    
 

  
    
    @GetMapping("/peso-ideal")
    public String getPesoIdealPage() {
        return "mostrar_peso";
    }
}
