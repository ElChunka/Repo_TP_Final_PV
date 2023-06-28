package ar.edu.unju.fi.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@GetMapping("/form-usuario")
	public String getUsuarioPage() {
		return "nuevo_usuario";
	}
}
