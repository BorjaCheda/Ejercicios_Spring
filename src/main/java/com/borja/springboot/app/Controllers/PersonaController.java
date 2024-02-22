package com.borja.springboot.app.Controllers;

import com.borja.springboot.app.Models.Persona;
import com.borja.springboot.app.Repositories.PersonaRepository;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller // Anotación para indicar nuestro controlador
public class PersonaController {

    @Autowired // Inyectamos el repositorio de personas
    PersonaRepository personaRepository;

    @GetMapping("/nuevaPersona") // Método para añadir nuevas personass
    public String nuevaPersona (Model model){
        Persona personas = new Persona();
        model.addAttribute("persona", personas);
        return "nueva_persona.html";
    }

    @PostMapping("/postForm") //Método para guardar esas personas en el repositorio y vuelve a la página para seguir añadiendo personas.
    public String postForm(@ModelAttribute("persona") Persona personas){
        personaRepository.save(personas);

        return "nueva_persona.html";
    }
}
