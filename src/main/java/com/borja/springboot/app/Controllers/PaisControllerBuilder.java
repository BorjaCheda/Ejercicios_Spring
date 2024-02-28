package com.borja.springboot.app.Controllers;

import com.borja.springboot.app.Services.PaisServiceImpl;

public class PaisControllerBuilder {
    private PaisServiceImpl paisService;

    public PaisControllerBuilder setPaisService(PaisServiceImpl paisService) {
        this.paisService = paisService;
        return this;
    }

    public PaisController createPaisController() {
        return new PaisController(paisService);
    }
}