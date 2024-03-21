package com.java.flexilab.DTO;

import com.java.flexilab.entities.sistem.HorarioClase;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter @Getter
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
    private List<Integer> clases;
    @NotNull(message = "El horario de la clase no puede estar vacio")
    private HorarioClase horarioClase;

    public CompraRealizadaDTO() {
        super();
    }

    public CompraRealizadaDTO(Integer id, Boolean activo, Integer precio, String metodoPago, String estado, List<Integer> productos, List<Integer> clases) {
        this.id = id;
        this.activo = activo;
        this.precio = precio;
        this.metodoPago = metodoPago;
        this.estado = estado;
        this.productos = productos;
        this.clases = clases;
    }

}
