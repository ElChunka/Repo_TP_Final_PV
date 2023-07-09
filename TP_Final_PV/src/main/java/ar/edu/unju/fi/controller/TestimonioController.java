package ar.edu.unju.fi.controller;

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

import ar.edu.unju.fi.entity.Testimonio;
import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.service.ITestimonioService;
import ar.edu.unju.fi.service.IUsuarioService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/testimonios")
public class TestimonioController {

    @Autowired
    private ITestimonioService testimonioService;
    
    @Autowired
    private IUsuarioService usuarioService;

    
    
    
	 // Maneja la solicitud GET para mostrar todos los testimonios.
	 
	
    @GetMapping("/lista")
    public String mostrarTodosTestimonios(Model model) {
    	// Obtener la lista de testimonios del servicio
        List<Testimonio> testimonios = testimonioService.listarTestimonios();
        
     // Ordenar los testimonios por fecha en orden descendente (más reciente primero)
        testimonios.sort(Comparator.comparing(Testimonio::getFecha)); // Orden ascendente
        Collections.reverse(testimonios); // Invertir el orden para obtener descendente
        
     // Agregar la lista de testimonios al modelo para que esté disponible en la vista
        model.addAttribute("testimonios", testimonios);
        return "testimonios";
    }
    
    
    // Maneja la solicitud GET para mostrar el formulario de nuevo testimonio.
    // El código de usuario pasado como parámetro.
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevoTestimonio(@RequestParam("codigoUsuario") int codigoUsuario, Model model) {
    	// Buscar el usuario en función del código de usuario proporcionado
    	Usuario usuario = usuarioService.buscarUsuario(codigoUsuario);
        
    	// Verificar si se encontró un usuario válido
    	if (usuario == null) {
    		// Si no se encontró un usuario válido, redirigir a la página de gestión de datos
            return "redirect:/gestion-datos";
        }
    	
    	// Agregar los atributos al modelo para que estén disponibles en la vista
        model.addAttribute("codigoUsuario", codigoUsuario);
        model.addAttribute("usuario", usuario);
        model.addAttribute("testimonio", new Testimonio());
        return "nuevo_testimonio";
    }

    
    // Maneja la solicitud POST para guardar un nuevo testimonio.
    // El testimonio enviado desde el formulario.
    @PostMapping("/guardar-testimonio")
    public String guardarTestimonio(@Valid @ModelAttribute("testimonio") Testimonio testimonio, BindingResult bindingResult, @RequestParam("codigoUsuario") int codigoUsuario, Model model) {
        
    	// Buscar el usuario en función del código de usuario proporcionado
    	Usuario usuario = usuarioService.buscarUsuario(codigoUsuario);
        
    	// Establecer el usuario en el testimonio
    	testimonio.setUsuario(usuario);
        if (bindingResult.hasErrors()) {
            // En caso de errores de validación, agregar el testimonio y los errores al modelo y volver al formulario
            model.addAttribute("testimonio", testimonio);
            model.addAttribute("edicion", false);
            model.addAttribute("codigoUsuario", codigoUsuario);
            return "nuevo_testimonio";
        } else {
        	// Si no hay errores de validación, guardar el testimonio utilizando el servicio
            testimonioService.guardarTestimonio(testimonio);
            return "redirect:/testimonios/lista";
        }
    }
    
    
    
    
    
    // Maneja la solicitud GET para mostrar el formulario de modificación de testimonio.
    // El ID del testimonio pasado como parámetro.
    @GetMapping("/modificar")
    public String mostrarFormularioModificarTestimonio(@RequestParam("id") Long id, Model model) {
        
    	// Buscar el testimonio en función del ID proporcionado
    	Testimonio testimonio = testimonioService.buscarPorId(id);
    	
    	// Buscar el usuario en función del ID proporcionado
        Usuario usuario = testimonioService.buscarPorId(id).getUsuario();
        
     // Verificar si se encontró un testimonio válido
        if (testimonio == null) {
        	
            return "redirect:/testimonios/lista";
        }
        
     // Agregar los atributos al modelo para que estén disponibles en la vista
        System.out.println(testimonio.getUsuario().getCodigo());
        model.addAttribute("testimonio", testimonio);
        model.addAttribute("codigoUsuario", testimonio.getUsuario().getCodigo());
        model.addAttribute("usuario", usuario);
        return "nuevo_testimonio";
    }
    
    
    
    // Maneja la solicitud POST para guardar la modificación de un testimonio.
	// El testimonio enviado desde el formulario.
    @PostMapping("/guardar-modificacion-testimonio")
    public String guardarModificacionTestimonio(@Valid @ModelAttribute("testimonio") Testimonio testimonio, BindingResult bindingResult, Model model) {
    	System.out.println(testimonio.getUsuario());
    	
    	// Verificar si hay errores de validación en el formulario
    	if (bindingResult.hasErrors()) {
            // En caso de errores de validación, agregar el testimonio y los errores al modelo y volver al formulario
            model.addAttribute("testimonio", testimonio);
            model.addAttribute("edicion", false);
            model.addAttribute("codigoUsuario", testimonio.getUsuario().getCodigo());
            return "nuevo_testimonio";
        } else {
        	// Si no hay errores de validación, guardar el testimonio utilizando el servicio
            testimonioService.guardarTestimonio(testimonio);
            return "redirect:/testimonios/lista";
        }
    }
    
    
    
    //Maneja la solicitud GET para eliminar un testimonio.
    //id El ID del testimonio pasado como parámetro.
    @GetMapping("/eliminar")
    public String eliminarTestimonio(@RequestParam("id") Long id) {
    	
    	// Eliminar el testimonio utilizando el servicio testimonioService
        testimonioService.eliminarTestimonio(id);
        
     // Redirigir a la página de gestión de datos
        return "redirect:/testimonios/lista";
    }

    
    
    
    
}
