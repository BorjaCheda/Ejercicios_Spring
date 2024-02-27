package com.borja.springboot.app.Services;

import com.borja.springboot.app.Models.Persona;
import com.borja.springboot.app.Repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Service
public class NumerosService {
    /**
     * @return String
     * <p>
     * Esta clase se encarga de devolver un SI o NO dependiendo si el número introducido es primo o no
     */
    public String isPrimo(String numero) {

        String esPrimo = "si es primo";
        int number = Integer.parseInt(numero);

        if (number <= 1) {
            esPrimo = "no es primo.";
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                esPrimo = "no es primo.";
            }
        }
        return esPrimo;
    }

    public Double calculoHipotenusa(Integer x, Integer y) {

        double hipotenusa;
        if (x <= 0 || y <= 0) {
            return hipotenusa = 0;
        } else {
            return hipotenusa = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        }
    }

    public Set<Integer> numerosSinRepetidos(Integer x) {

        Set<Integer> numerosUnicos = new TreeSet<>(); // Los números introducios ya se van ordenando y sin repetirse
        if (x < 1 || x > 100){
            return numerosUnicos;
        } else {
            while (numerosUnicos.size() < x) {
                numerosUnicos.add((int) (Math.random() * 100) + 1); // Generar números entre 1 y 100
            }
            return numerosUnicos;
        }
    }

    public Set<Integer> divisores(Integer x) {

        Set<Integer> divisores = new TreeSet<>(); // Los números introducios ya se van ordenando y sin repetirse
        divisores.add(x);

        for (int i = 1; i <= x/2; i++){
            if (x%i == 0){
                divisores.add(i);
            }
        }
        return divisores;
    }
}


