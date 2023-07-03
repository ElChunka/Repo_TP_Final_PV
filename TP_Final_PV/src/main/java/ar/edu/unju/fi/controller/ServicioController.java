package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.service.imp.IMCServiceImp;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/servicios")
public class ServicioController {
	
	@Autowired
	@Qualifier()
	private IMCServiceImp imcServiceImp;
	
    @GetMapping("/imc")
    public String getImcPage(Model model) {
    	model.addAttribute("servicios", imcServiceImp.getClass());
        return "mostrar_imc";
    }
    
    @PostMapping("/guardar")
    public ModelAndView getGuardarNuevoImcPage(@Valid @ModelAttribute("servicio") ServicioController servicio, BindingResult result) {
    	ModelAndView modelView = new ModelAndView("servicios");
    	if(result.hasErrors()) {
    		modelView.setViewName("nuevo_imc");
    		modelView.addObject("servicio", servicio);
    		return modelView;
    	}
    	imcServiceImp.CalcularIMC(null);
    	modelView.addObject("servicio", servicioService.getServicios());
		return modelView;
    }

    @GetMapping("/peso-ideal")
    public String getPesoIdealPage() {
        return "mostrar_peso";
    }
}
