package com.borja.springboot.app.Services;

import java.util.List;

public interface FechasFormularioService {
    String obtenerFecha();

    Integer diasTranscurridos(String fecha);

    Integer dosFechas(String fecha1, String fecha2);

    String esBisiesto(String fecha1);

    List<Integer> añosBisiestos(Integer año1, Integer año2);
}
