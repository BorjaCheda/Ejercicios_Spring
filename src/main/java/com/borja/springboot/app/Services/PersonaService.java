package com.borja.springboot.app.Services;

import com.borja.springboot.app.Models.Persona;
import com.borja.springboot.app.Repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PersonaService {

    @Autowired // Inyectamos el repositorio de personas
    PersonaRepository personaRepository;

    public void save(Persona persona){
        personaRepository.save(persona);
    }

    public List<Persona> findAll(){
       return personaRepository.findAll();
    }


    /**
     *
     * @return Persona
     *
     * Esta clase se encarga de devolver la mayor de las personas en edad. Calculo sobre Servicio
     *
     */
    public Persona findMayorPersona(){
        List<Persona> listaPersonas = personaRepository.findAll();
        int edad_mayor = 0;
        Persona mayorPersona= new Persona();

        for (Persona p: listaPersonas){
            if (p.getEdad() > edad_mayor){
                edad_mayor = p.getEdad();
                mayorPersona=p;
            }
        }
        return mayorPersona;
    }

}
