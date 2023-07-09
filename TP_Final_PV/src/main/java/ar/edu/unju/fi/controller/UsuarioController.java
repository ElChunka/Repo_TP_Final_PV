package ar.edu.unju.fi.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.service.IUsuarioService;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	
	@Autowired
	private IUsuarioService userService;
	
	
	@GetMapping("/form-usuario")
	public String getUsuarioPage(Model model) {
		model.addAttribute("usuario", userService.getUsuario());
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
			userService.Guardar(usuario);
			modelView.addObject("usuario", usuario);
			modelView.setViewName("redirect:/usuario/codigo/"+usuario.getCodigo());
			return modelView;
		}
	 
	 @GetMapping("/codigo/{codigo}")
	 public String getCodigoPage(Model model, @PathVariable(value = "codigo") int codigo) {
		 model.addAttribute("usuario", userService.buscarUsuario(codigo));
	return "codigo_usuario";
	}
	 

}
