package com.borja.springboot.app.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controlador_Ejercicio3 {


    @GetMapping({"/","/index","/home"})
    public String index () {
        return "indexView.html";
    }
    @GetMapping ("/quienes-somos")
    public String quienes_somos () {
        return "aboutUsView.html";
    }
    @GetMapping ("/productos")
    public String productos () {
        return "productsView.html";
    }
    @GetMapping ("/contacta")
    public String contacta () {
        return "contactView.html";
    }
}
