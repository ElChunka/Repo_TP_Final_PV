package ar.edu.unju.fi.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/testimonios")
public class TestimonioController {
	
	@GetMapping("/lista")
	public String getTestimoniosPage() {
		return "testimonios";
	}
	
	
	@GetMapping("/nuevo-testimonio")
	public String getTestimonioFormPage() {
		return "nuevo_testimonio";
	}
}
