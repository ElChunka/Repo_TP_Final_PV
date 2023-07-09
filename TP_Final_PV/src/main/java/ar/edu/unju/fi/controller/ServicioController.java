package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/servicios")
public class ServicioController {

    @GetMapping("/imc")
    public String getImcPage() {
        return "mostrar_imc";
    }
    
    /*@PostMapping("/guardar")
    public ModelAndView getGuardarNuevoImcPage(@Valid @ModelAttribute("imc")ServicioController servicio, BindingResult result) {
    	ModelAndView modelView = new ModelAndView("imc");
    	if(result.hasErrors()) {
    		modelView.setViewName(getImcPage());
    		modelView.addObject("imc", servicio);
    	}
    	return modelView;
    }*/
    

    @GetMapping("/peso-ideal")
    public String getPesoIdealPage() {
        return "mostrar_peso";
    }
}
