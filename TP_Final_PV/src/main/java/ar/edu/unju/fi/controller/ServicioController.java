package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.service.IUsuarioService;

@Controller
@RequestMapping("/servicios")
public class ServicioController {
	@Autowired
	private IUsuarioService usuarioService;
	
    @GetMapping("/imc")
    public String getImcPage() {
        return "mostrar_imc";
    }

    @GetMapping("/peso-ideal")
    public String getPesoIdealPage() {
        return "mostrar_peso";
    }
    @PostMapping("/verificar-codigo-peso")
    public String verificarCodigoUsuarioPeso(@RequestParam("codigoUsuario") int codigoUsuario, Model model){
	    Usuario usuario = usuarioService.buscarUsuario(codigoUsuario);
	    if(usuario != null) {
	    	model.addAttribute("usuarioValido", true);
	    	model.addAttribute("usuario", usuario);
	    }else {
	    	model.addAttribute("usuarioValido", false);
	    }
	    return "mostrar_peso";
    }
}
