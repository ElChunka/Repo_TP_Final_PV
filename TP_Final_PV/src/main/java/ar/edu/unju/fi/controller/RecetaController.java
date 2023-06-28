package ar.edu.unju.fi.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/recetas")
public class RecetaController {
	
	
	@GetMapping("/lista")
	public String getRecetasPage() {
		return "recetas";
	}
	
	@GetMapping("/preparacion")
	public String getPreparacionPage() {
		return "mostrar_receta";
	}
	
	@GetMapping("/nueva-receta")
	public String getRecetasFormPage() {
		return "nueva_receta";
	}
}
