package com.borja.springboot.app.Services;

import com.borja.springboot.app.Models.Pais;

import java.util.List;

public interface PaisService {
    //List<String> cargarPaisesDesdeFichero();

    List<String> getPaises();

    Pais getPais(String nombre);

}

