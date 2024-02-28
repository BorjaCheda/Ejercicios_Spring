package com.borja.springboot.app.Services;

import com.borja.springboot.app.Models.Pais;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PaisServiceImpl implements PaisService{

    private List<Pais> paises = new ArrayList<>();
    @Override
    public List<String> cargarPaisesDesdeFichero() {
        List<String> lineas = new ArrayList<>();
        try {
            lineas = Files.readAllLines(Paths.get("paises2019.csv"));
            for (String linea : lineas) {
                String[] datos = linea.split(",");
                paises.add(new Pais(datos[0], datos[1], Integer.parseInt(datos[2])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lineas;
    }

    @Override
    public List<String> getPaises() {
        return null;
    }

    @Override
    public Pais getPais(String nombre) {
        return null;
    }
}
