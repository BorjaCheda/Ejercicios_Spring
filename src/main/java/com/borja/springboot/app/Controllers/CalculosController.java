package com.borja.springboot.app.Controllers;

import com.borja.springboot.app.Services.NumerosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;
import java.util.TreeSet;

@Controller
@RequestMapping("/calculos")
public class CalculosController {

    @Autowired /* Inyectamos el Servicio */
    NumerosService numerosService;
    @GetMapping ("/index")
    public String insertNumber(){
        return "index.html";
    }
    @GetMapping("/primo")
    public String numberPrimo(@RequestParam(required=false,defaultValue="X") String numero, Model model ){

        if (numero.equalsIgnoreCase("X")) {
            return "error.html";
        } else {
            String resultado = numerosService.isPrimo(numero);

            model.addAttribute("numero", numero);
            model.addAttribute("resultado", resultado);

            return "primo.html";
        }
    }

    @GetMapping("/hipotenusa/{x}/{y}")
    public String hipotenusa(@PathVariable Integer x, @PathVariable Integer y, Model model ){

        Double hipotenusa = numerosService.calculoHipotenusa(x, y);

        if (hipotenusa == 0){
            return "error.html";
        } else {
            model.addAttribute("x", x);
            model.addAttribute("y", y);
            model.addAttribute("hipotenusa", hipotenusa);
            return "hipotenusa.html";
        }
    }

    @GetMapping("/sinRepetidos/{x}")
    public String sinRepetidos(@PathVariable Integer x, Model model ){

        Set<Integer> numerosUnicos = numerosService.numerosSinRepetidos(x);

        if (numerosUnicos.isEmpty()){
            return "error.html";
        } else {
            model.addAttribute("numerosUnicos", numerosUnicos);
            return "sinRepetidos.html";
        }
    }

    @GetMapping("/divisores/{x}")
    public String divisores(@PathVariable Integer x, Model model ){

        Set<Integer> divisores = numerosService.divisores(x);

        model.addAttribute("x", x);
        model.addAttribute("divisores", divisores);

        return "divisores.html";

    }
}
