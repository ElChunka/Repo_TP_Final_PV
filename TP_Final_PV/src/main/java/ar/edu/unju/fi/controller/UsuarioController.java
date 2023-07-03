package ar.edu.unju.fi.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.repository.IUsuarioRepository;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private IUsuarioRepository userRepository;
	
	@Autowired
	private Usuario usuario;
	
	@GetMapping("/form-usuario")
	public String getUsuarioPage(Model model) {
		model.addAttribute("usuario", usuario);
		return "nuevo_usuario";
	}
	
	 @PostMapping("/guardar")
		public ModelAndView getGuardarNuevoServicioPage(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result) {
			ModelAndView modelView = new ModelAndView("nuevo_usuario");
			if(result.hasErrors()) {
				modelView.setViewName("nuevo_usuario");
				modelView.addObject("usuario", usuario);
				return modelView;
			}
			userRepository.save(usuario);
			modelView.addObject("usuario", usuario);
			modelView.setViewName("redirect:/index");
			return modelView;
		}
}
