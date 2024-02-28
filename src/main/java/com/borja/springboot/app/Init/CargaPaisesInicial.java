package com.borja.springboot.app.Init;

import com.borja.springboot.app.Services.PaisService;
import org.springframework.boot.CommandLineRunner;

public class CargaPaisesInicial implements CommandLineRunner {

    private final PaisService paisService;

    public CargaPaisesInicial(PaisService paisService){
        this.paisService = paisService;
    }

    @Override
    public void run(String... args) throws Exception {
        paisService.cargarPaisesDesdeFichero();
    }
}
