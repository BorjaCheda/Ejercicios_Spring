package com.borja.springboot.app.Controllers;

import com.borja.springboot.app.Services.FechasService;
import com.borja.springboot.app.Services.FechasServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/fechas")
public class FechasController {

    @Autowired /* Inyectamos el Servicio de Fechas */
            FechasServiceImpl fechasService;
    @GetMapping("/")
    public String Index (Model model){

        model.addAttribute("fecha_hoy", fechasService.obtenerFecha());
        return "fechas.html";
    }

    @GetMapping("/diasTranscurridos")
    public String diasTranscurridos (@RequestParam(required=false,defaultValue="x") String fecha, Model model){

        model.addAttribute("fecha", fecha);
        model.addAttribute("fecha_hoy", fechasService.obtenerFecha());
        model.addAttribute("dias_transcurridos", fechasService.diasTranscurridos(fecha));
        return "diasTranscurridos.html";

    }

    @GetMapping("/dosFechas")
    public String dosFechas (@RequestParam(required=false,defaultValue="x") String fecha1, @RequestParam(required=false,defaultValue="y") String fecha2, Model model){

        model.addAttribute("fecha1", fecha1);
        model.addAttribute("fecha2", fecha2);
        model.addAttribute("fecha_hoy", fechasService.obtenerFecha());
        model.addAttribute("dias_transcurridos_dos_fechas", fechasService.dosFechas(fecha1,fecha2));
        return "dosFechas.html";

    }

    @GetMapping("/bisiesto/{fecha1}")
    public String esBisiesto (@PathVariable String fecha1, Model model){

        model.addAttribute("fecha1", fecha1);
        model.addAttribute("resultado", fechasService.esBisiesto(fecha1));

        return "bisiesto.html";

    }
    @GetMapping("/bisiesto/{año1}/{año2}")
    public String añosBisiestos (@PathVariable Integer año1, @PathVariable Integer año2, Model model){

        model.addAttribute("año1", año1);
        model.addAttribute("año2", año2);

        model.addAttribute("años", fechasService.añosBisiestos(año1, año2));

        return "añosBisiestos.html";

    }

}