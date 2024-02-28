package com.borja.springboot.app.Services;

import java.util.Set;

public interface NumerosService {
    String isPrimo(String numero);

    Double calculoHipotenusa(Integer x, Integer y);

    Set<Integer> numerosSinRepetidos(Integer x);

    Set<Integer> divisores(Integer x);
}
