package com.borja.springboot.app.Services;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class FechasServiceImpl implements FechasService {
    LocalDate fecha = LocalDate.now();

    @Override
    public String obtenerFecha() {

        String fecha_formateada = fecha.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return fecha_formateada;
    }

    @Override
    public Integer diasTranscurridos(String fecha) {
        LocalDate fecha_convertida = LocalDate.parse(fecha, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Integer diasTranscurridos = fecha_convertida.getDayOfYear();
        return diasTranscurridos;
    }

    @Override
    public Integer dosFechas(String fecha1, String fecha2) {
        LocalDate fecha_convertida1 = LocalDate.parse(fecha1, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate fecha_convertida2 = LocalDate.parse(fecha2, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        Integer diasTranscurridosDosFechas = Math.toIntExact(Math.abs((fecha_convertida1.toEpochDay()) - (fecha_convertida2.toEpochDay())));
        return diasTranscurridosDosFechas;
    }

    @Override
    public String esBisiesto(String fecha1) {

        int indiceGuion = fecha1.indexOf("-");

        int anio = Integer.parseInt(fecha1.substring(0, indiceGuion));

        if ((anio % 4 == 0) && ((anio % 100 != 0) || (anio % 400 == 0)))
            return "El año es bisiesto";
        else
            return "El año no es bisiesto";
    }

    @Override
    public List<Integer> añosBisiestos(Integer año1, Integer año2) {

        List<Integer> añosBisiestos = new ArrayList<>();

        if (año1 >= año2) {
            for (int i = año2; i <= año1; i++) {
                if ((i % 4 == 0) && ((i % 100 != 0) || (i % 400 == 0))) {
                    añosBisiestos.add(i);
                }
            }
        } else {
            for (int i = año1; i <= año2; i++) {
                if ((i % 4 == 0) && ((i % 100 != 0) || (i % 400 == 0))) {
                    añosBisiestos.add(i);
                }
            }
        }
        return añosBisiestos;
    }
}
