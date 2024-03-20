package com.java.flexilab.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.java.flexilab.entities.sistem.Producto;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter @Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CompraRealizadaDTOupdate {

    private Integer id;
    @NotNull(message = "El precio no puede estar vacio")
    private Integer precio;

    @NotNull(message = "El metodo de pago no puede estar vacio")
    private String metodoPago;


    @NotNull(message = "El estado no puede estar vacio")
    private String estadoCompra;


    private List<ClaseDTOupdate> clases;

    public CompraRealizadaDTOupdate() {
        super();
        this.clases = new ArrayList<>();
    }
}
