package com.java.flexilab.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
public class CompraRealizadaDTO {

    private Integer id;
    private Boolean activo;
    private Date fecha;
    @NotNull(message = "El precio no puede estar vacio")
    private Integer precio;
    @NotNull(message = "El metodo de pago no puede estar vacio")
    private String metodoPago;
    @NotNull(message = "El estado no puede estar vacio")
    private String estado;
    @NotNull(message = "Las clases no pueden estar vacias")
    private List<Integer> productos;
    @NotNull(message = "Los productos no pueden estar vacios")
    private List<ClaseDTOpost> clases;

    // Constructor, getters y setters
}

