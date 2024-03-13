package com.java.flexilab.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter @Getter
public class CompraRealizadaDTO {

    @NotNull(message = "El precio no puede estar vacio")
    private Integer precio;
    @NotNull(message = "El metodo de pago no puede estar vacio")
    private String metodoPago;
    @NotNull(message = "El estado no puede estar vacio")
    private String estado;
    @NotNull(message = "Las clases no pueden estar vacias")
    private List<Integer> productos;
    @NotNull(message = "Los productos no pueden estar vacios")
    private List<Integer> clases;

}
