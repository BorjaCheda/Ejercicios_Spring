package com.borja.springboot.app.Services;

import com.borja.springboot.app.Models.Pais;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class PaisServiceImpl implements PaisService{

    List<Pais> paises = new ArrayList<>();
    @Override
    public List<String> cargarPaisesDesdeFichero() {
       List<String> lineas = new ArrayList<>();

       try {
            // Lee el archivo desde la carpeta src/main/resources
           lineas = Files.readAllLines(Paths.get(getClass().getResource("/paises2019.csv").toURI()), StandardCharsets.UTF_8);
            for (String linea : lineas) {
                String[] datos = linea.split(";");
               paises.add(new Pais(datos[0], datos[1], Integer.parseInt(datos[2])));
           }
           } catch (IOException | URISyntaxException e) {
           e.printStackTrace();
      }
        return lineas;
 }

    @Override
    public List<String> getPaises(){
        List<String> nombrePaises = new ArrayList<>();

        for (Pais p : paises ){
            nombrePaises.add(p.getNombre());
        }
        return nombrePaises;
    }

    @Override
    public Pais getPais(String nombre){

        for (Pais p : paises){
            if (p.getNombre().equals(nombre)){
                return new Pais(p.getNombre(),p.getCapital(), p.getPoblacion());
            }
        }
        return null;
    }
}
