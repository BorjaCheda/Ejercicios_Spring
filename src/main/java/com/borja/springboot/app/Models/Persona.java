package com.borja.springboot.app.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity // Anotación de Entidad para la Clase Persona
@Data // Anotación para añadir internamente los métodos Getter, Setter, toString...
@Table // Indicamos que es una tabla
@EqualsAndHashCode (of = "dni") // Método EqualsyHashCode basado en DNI únicamente.
public class Persona {

    @Column
    private String dni;

    @Column
    private String nombre;

    @Column
    private int edad;

}
