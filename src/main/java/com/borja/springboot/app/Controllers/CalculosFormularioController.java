package com.borja.springboot.app.Controllers;

import com.borja.springboot.app.Models.FormInfo;
import com.borja.springboot.app.Models.Persona_Formulario;
import com.borja.springboot.app.Services.CalculosFormularioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
@RequestMapping("/calculosFormulario")
public class CalculosFormularioController {

    @Autowired /* Inyectamos el Servicio */
            CalculosFormularioServiceImpl numerosService;

    @GetMapping("/")
    public String chooseOption() {

        return "inicioCalculosFechas.html";
    }

    @GetMapping("/myForm")
    public String getForm(FormInfo formInfo){

        return "formBaseNumeros.html";
    }

//     @PostMapping("/postFormPrimo")
//    public String postFormPrimo(String number, Model model) {
//
//            numerosService.isPrimo(number);
//            model.addAttribute("numero", number);
//            model.addAttribute("resultado", numerosService.isPrimo(number));
//            return "primo.html";
//
//    }

   @PostMapping("/postFormPrimo")
    public String postFormPrimo(@Valid FormInfo formInfo, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()){
            return "errorFormulario.html";
        } else{
            numerosService.isPrimo(formInfo.getNumber().toString());
            model.addAttribute("numero", formInfo.getNumber());
            model.addAttribute("resultado", numerosService.isPrimo(formInfo.getNumber().toString()));
            return "primo.html";
        }
    }

    /*@PostMapping("/postFormHipotenusa")
    public String postFormHipotenusa(@Valid Integer cateto1, @Valid Integer cateto2, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()){
            return "errorFormulario.html";
        } else {
            Double hipotenusa = numerosService.calculoHipotenusa(cateto1, cateto2);
            model.addAttribute("x", cateto1);
            model.addAttribute("y", cateto2);
            model.addAttribute("hipotenusa", hipotenusa);
            return "hipotenusa.html";
        }
    } */

    @PostMapping("/postFormHipotenusa")
    public String postFormHipotenusa(Integer cateto1,Integer cateto2, Model model) {

            Double hipotenusa = numerosService.calculoHipotenusa(cateto1, cateto2);
            model.addAttribute("x", cateto1);
            model.addAttribute("y", cateto2);
            model.addAttribute("hipotenusa", hipotenusa);
            return "hipotenusa.html";

    }

    @PostMapping("/postFormDivisores")
    public String postFormDivisores(Integer number, Model model) {

        Set<Integer> divisores = numerosService.divisores(number);

        model.addAttribute("x", number);
        model.addAttribute("divisores", divisores);

        return "divisores.html";

    }
}

