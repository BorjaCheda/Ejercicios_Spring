package com.borja.springboot.app.Controllers;

import com.borja.springboot.app.Models.Persona;
import com.borja.springboot.app.Repositories.PersonaRepository;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller // Anotación para indicar nuestro controlador
public class PersonaController {

    @Autowired // Inyectamos el repositorio de personas
    PersonaRepository personaRepository;

    @GetMapping("/nuevaPersona") // Método para añadir nuevas personas
    public String nuevaPersona (Model model){
        Persona persona = new Persona();
        model.addAttribute("persona", persona);
        return "nueva_persona.html";
    }

    @PostMapping("/postForm") //Método para guardar esas personas en el repositorio y vuelve a la página para seguir añadiendo personas.
    public String postForm(@ModelAttribute("persona") Persona persona){
        personaRepository.save(persona);

        return "redirect:/nuevaPersona";
    }
    @GetMapping("/listaPersonas")
    public String listaPersonas(@ModelAttribute("persona") Persona persona, Model model){

        List<Persona> listaPersonas = personaRepository.findAll();
        model.addAttribute("listaPersonas", listaPersonas);

        return "lista_personas.html";
    }

    @GetMapping("/edadMayor")
    public String edadMayor(@ModelAttribute("persona") Persona persona, Model model){

        List<Persona> listaPersonas = personaRepository.findAll();
        int edad_mayor = 0;

        for (Persona p: listaPersonas){
            if (p.getEdad() > edad_mayor){
                edad_mayor = p.getEdad();
            }
            model.addAttribute("edad", edad_mayor);
        }
        return "edadMayor.html";
    }

    @GetMapping("/edadMedia")
    public String edadMedia(@ModelAttribute("persona") Persona persona, Model model){

        List<Persona> listaPersonas = personaRepository.findAll();
        int suma_edades = 0;

        for (Persona p: listaPersonas){
            suma_edades = suma_edades + p.getEdad();
        }
        int edad_media = (suma_edades) / (listaPersonas.size());
        model.addAttribute("edad_media", edad_media);
        return "edadMedia.html";
    }
    @GetMapping("/nombreMayor")
    public String nombreMayor(@ModelAttribute("persona") Persona persona, Model model){

        List<Persona> listaPersonas = personaRepository.findAll();
        int edad_mayor = 0;
        String nombre ="";

        for (Persona p: listaPersonas){
            if (p.getEdad() > edad_mayor){
                edad_mayor = p.getEdad();
                nombre = p.getNombre();
            }
            model.addAttribute("nombre", nombre);
        }
        return "nombreMayor.html";
    }

    @GetMapping("/mayoresEdad")
    public String mayoresEdad(@ModelAttribute("persona") Persona persona, Model model){

        List<Persona> listaPersonas = personaRepository.findAll();
        ArrayList<Persona> mayoresEdad = new ArrayList<>();

        for (Persona p: listaPersonas){
            if (p.getEdad() >= 18){
                mayoresEdad.add(p);
            }
            model.addAttribute("mayoresEdad", mayoresEdad);
        }
        return "mayoresEdad.html";
    }

    @GetMapping("/mayorigualmedia")
    public String mayorigualmedia(@ModelAttribute("persona") Persona persona, Model model){

        List<Persona> listaPersonas = personaRepository.findAll();
        ArrayList<Persona> mayoresigualmedia = new ArrayList<>();
        int suma_edades = 0;

        for (Persona p: listaPersonas){
            suma_edades = suma_edades + p.getEdad();
        }
        int edad_media = (suma_edades) / (listaPersonas.size());

        for (Persona p: listaPersonas) {
            if (p.getEdad() >= edad_media) {
                mayoresigualmedia.add(p);
            }
        }

        model.addAttribute("mayores_igual_media", mayoresigualmedia);
        return "mayorigualmedia.html";
    }

}
