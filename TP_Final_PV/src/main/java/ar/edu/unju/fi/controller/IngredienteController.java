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

import ar.edu.unju.fi.entity.Ingrediente;
import ar.edu.unju.fi.service.IIngredienteService;
import ar.edu.unju.fi.service.IRecetaService;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/ingredientes")
public class IngredienteController {

	@Autowired
	@Qualifier("recetaServiceMysql")
	private IRecetaService recetaService;
	
	@Autowired
	private IIngredienteService ingredienteService;
	
	@GetMapping("/nuevo")
	public String getIngredientesFormPage(Model model) {
		model.addAttribute("ingrediente", ingredienteService.getIngrediente());
		return "nuevo_ingrediente";
	}
	
	@PostMapping("/guardar")
	public ModelAndView getGuardarNuevoIngredientePage(@Valid @ModelAttribute("ingrediente") Ingrediente ingrediente, BindingResult result) {
		ModelAndView modelView = new ModelAndView("recetasql");
		if(result.hasErrors()) {
			modelView.setViewName("nuevo_ingrediente");
			modelView.addObject("ingrediente", ingrediente);
			return modelView;
		}
		
		ingredienteService.guardar(ingrediente);
		modelView.addObject("recetas", recetaService.getRecetas());
		return modelView;
	}
}
