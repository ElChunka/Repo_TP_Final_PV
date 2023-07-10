package ar.edu.unju.fi.controller;
import java.net.MalformedURLException;


import org.springframework.core.io.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Ingrediente;
import ar.edu.unju.fi.entity.Receta;
import ar.edu.unju.fi.service.IIngredienteService;
import ar.edu.unju.fi.service.IRecetaService;
import ar.edu.unju.fi.util.UploadFile;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/recetas")
public class RecetaController {
	
	@Autowired
	@Qualifier("recetaServiceMysql")
	private IRecetaService recetaService;
	
	@Autowired
	private IIngredienteService ingredienteService;
	
	@Autowired
	private Receta receta;
	
	@Autowired
	private UploadFile uploadFile;
	
	@GetMapping("/lista")
	public String getRecetasPage(Model model) {
		model.addAttribute("recetas", recetaService.getRecetas());
		return "recetasql";
	}
	
	@GetMapping("/preparacion/{id}")
	public ModelAndView getRecetapage(@PathVariable("id") Long id) {
		ModelAndView modelView = new ModelAndView("mostrar_receta");
		receta = recetaService.getBy(id);
		modelView.addObject("receta", receta);
		modelView.addObject("filename", receta.getImagen());
		modelView.addObject("ingredientes", receta.getIngredientes());
		return modelView;
	}
	
	@GetMapping("/nueva-receta")
	public String getRecetasFormPage(Model model) {
		model.addAttribute("receta", recetaService.getReceta());
		model.addAttribute("ingredientes", ingredienteService.getIngredientes());
		return "nueva_receta";
	}
	
	@PostMapping("/guardar")
	public ModelAndView getGuardarNuevaRecetaPage(@Valid @ModelAttribute("receta") Receta receta, BindingResult result,
			@RequestParam("file") MultipartFile image) throws Exception{
		
		ModelAndView modelView = new ModelAndView("recetasql");
		if(result.hasErrors()) {
			modelView.setViewName("nueva_receta");
			modelView.addObject("receta", receta);
			modelView.addObject("ingredientes", ingredienteService.getIngredientes());
			return modelView;
		}
		
		if(!image.isEmpty())
		{
			String uniqueFileName = uploadFile.copy(image);
			receta.setImagen(uniqueFileName);
		}
		
		recetaService.guardar(receta);
		modelView.addObject("recetas", recetaService.getRecetas());
		return modelView;
	}
	
	@GetMapping("/uploads/{filename}")
	public ResponseEntity<Resource> goImage(@PathVariable String filename){
		Resource resource = null;
		try {
			resource = uploadFile.load(filename);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
				.body(resource);
	}
}
