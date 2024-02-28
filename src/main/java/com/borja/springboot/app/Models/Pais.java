package com.borja.springboot.app.Models;

import lombok.Data;


import java.util.*;
@Data
public class Pais {
    private String nombre;
    private String capital;
    private int poblacion;

    public Pais(String nombre, String capital, int poblacion) {
        this.nombre = nombre;
        this.capital = capital;
        this.poblacion = poblacion;
    }
}



