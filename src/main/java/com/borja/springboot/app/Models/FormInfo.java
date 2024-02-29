package com.borja.springboot.app.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Data;



@Data

public class FormInfo {


    @Min(value = 2, message = "el valor minimo debe ser 2")
    @Max(value = 10, message = "el valor maximo debe ser 10")
    private Integer number;


    @Min(1)
    @Max(100)
    private Integer cateto1;

    @Min(5)
    @Max(55)
    private Integer cateto2;
}
