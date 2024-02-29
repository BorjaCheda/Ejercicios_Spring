package com.borja.springboot.app.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Data;



@Data
@Entity
public class FormInfo {

    @Id
    @Min(2)
    @Max(10)
    private Integer number;

    @NotNull
    @NotEmpty
    @Min(1)
    @Max(100)
    private Integer cateto1;

    @Min(5)
    @Max(55)
    private Integer cateto2;
}
