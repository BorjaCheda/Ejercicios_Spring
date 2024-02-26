package com.borja.springboot.app.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

@Controller
public class Controlador_Ejercicio3 {
    @GetMapping({"/","/home"})
    public String index (@RequestParam (required=false,defaultValue="nombrevacio") String nombre, Model model) {

        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fecha_formateada = ahora.format(formatter);

        model.addAttribute("fecha_hoy", fecha_formateada);

        System.out.println(nombre);
        System.out.println(nombre.equalsIgnoreCase("nombrevacio"));

        if (nombre.equalsIgnoreCase("nombrevacio")){
            return "insertanombre.html";
        } else {
            model.addAttribute("nombre", nombre);
            return "indexView.html";
        }
    }
    @GetMapping ("/quienes-somos")
    public String quienes_somos () {
        return "aboutUsView.html";
    }
    @GetMapping ("/productos")
    public String productos (Model model) {
        ArrayList<String> productos = new ArrayList<>();
        productos.add("Producto 1");
        productos.add("Producto 2");
        productos.add("Producto 3");
        productos.add("Producto 4");

        model.addAttribute("listaproductos", productos);

        return "productsView.html";
    }
    @GetMapping ("/contacta")
    public String contacta () {
        return "contactView.html";
    }
}
