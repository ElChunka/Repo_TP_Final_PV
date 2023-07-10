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

import ar.edu.unju.fi.entity.IMC;
import ar.edu.unju.fi.entity.IndiceMasaCorporal;
import ar.edu.unju.fi.entity.Testimonio;
import ar.edu.unju.fi.service.imp.IMCServiceImp;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/servicios")
public class ServicioController {

	@Autowired
	IMCServiceImp imcService;
	
    @GetMapping("/imc")
    public String getImcPage() {
        return "mostrar_imc";
    }
    
    
    
    @PostMapping("/guardar")
    public ModelAndView getGuardarNuevoImcPage(@RequestParam("peso") Double peso, ServicioController servicio, BindingResult result,  Model model) {
    	ModelAndView modelView = new ModelAndView("mostrar_imc");
    	this.imcService.calcularIMC(peso);
    	if(result.hasErrors()) {
    		modelView.setViewName(getImcPage());
    		modelView.addObject("imc", servicio);
    	}
    	return modelView;
    }
    
    
    @GetMapping("/indiceMasa")
    public List<IndiceMasaCorporal> getAllImcList(Model model) {
    	System.out.println("aaa");
    	List<IndiceMasaCorporal> indiceMasa = new ArrayList<>();
    	indiceMasa = this.imcService.getAllIndices();
        model.addAttribute("in", indiceMasa);
    	return indiceMasa;
    }
    
    
 

  
    
    @GetMapping("/peso-ideal")
    public String getPesoIdealPage() {
        return "mostrar_peso";
    }
}
