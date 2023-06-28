package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/servicios")
public class ServicioController {

    @GetMapping("/imc")
    public String getImcPage() {
        return "mostrar_imc";
    }

    @GetMapping("/peso-ideal")
    public String getPesoIdealPage() {
        return "mostrar_peso";
    }
}
