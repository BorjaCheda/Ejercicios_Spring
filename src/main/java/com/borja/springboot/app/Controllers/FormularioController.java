package com.borja.springboot.app.Controllers;

import com.borja.springboot.app.Models.Persona_Formulario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
@RequestMapping("/Formulario")
public class FormularioController {

    @GetMapping("/myForm")
    public String getForm(Model model){
        Persona_Formulario persona_formulario = new Persona_Formulario();
        model.addAttribute("persona_formulario", persona_formulario);
        return "formBase.html";
    }

    @PostMapping("/postForm")
    public String postForm(@ModelAttribute("persona") Persona_Formulario persona_formulario, Model model) {

        model.addAttribute("datos_persona", persona_formulario);

        return "persona.html";
    }
}
