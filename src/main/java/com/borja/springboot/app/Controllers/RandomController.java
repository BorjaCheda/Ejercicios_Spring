package com.borja.springboot.app.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedList;
import java.util.Random;

@Controller
@RequestMapping("aleatorios/")
public class RandomController {
    LinkedList<Integer> numeros_aleatorios = new LinkedList<>();

    @GetMapping("/lista")
    public String numerosAleatorios(Model model){

        model.addAttribute("numeros_aleatorios", numeros_aleatorios);

        return "lista_aleatorios";
    }

    @GetMapping("/nuevo")
    public String nuevoNumero (Model model){

        int numero_aleatorio = (int)((Math.random()*100) + 1);

        numeros_aleatorios.add(numero_aleatorio);

        model.addAttribute("numeros_aleatorios", numeros_aleatorios);

        return "redirect:/aleatorios/lista";
    }

    @GetMapping("/eliminar/{numero}")
    public String eliminarAleatorio(@PathVariable Integer numero, Model model){

        numeros_aleatorios.remove(numero);
        return "redirect:/aleatorios/lista";
    }
}