package com.borja.springboot.app.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity // Anotación de Entidad para la Clase Persona
@Data // Anotación para añadir internamente los métodos Getter, Setter, toString...
@Table // Indicamos que es una tabla
public class Persona_Formulario {

    @Id
    @Column
    private String nombre;

    @Column
    private Integer edad;

}
