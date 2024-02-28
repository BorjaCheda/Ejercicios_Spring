package com.borja.springboot.app.Controllers;

import com.borja.springboot.app.Models.Pais;
import com.borja.springboot.app.Services.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/paises")
public class PaisController {
    @Autowired
    PaisService paisService;

    @GetMapping("/")
    public String mostrarFormulario(Model model) {
        paisService.cargarPaisesDesdeFichero();
        model.addAttribute("paises", paisService.getPaises());
        return "formularioPaises";
    }

    @PostMapping("/")
    public String mostrarDatosPais(@RequestParam("nombre") String nombre, Model model) {

        model.addAttribute("pais", paisService.getPais(nombre));
        return "formularioPaises";
    }

}
