package com.java.flexilab.entities.sistem;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.flexilab.DTO.ClaseCantidadDTO;
import jakarta.persistence.*;

import com.java.flexilab.entities.Base;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Setter
@Getter
@Entity
@AllArgsConstructor
public class CompraRealizada extends Base {

    @Column
    private Date fecha;
    @NotNull(message = "El precio no puede estar vacio")
    @Column
    private Integer precio;
    @NotNull(message = "El metodo de pago no puede estar vacio")
    @Column
    private EnumMetodoPago metodoPago;
    @NotNull(message = "El estado no puede estar vacio")
    @Column
    private EnumEstadoCompra estado;

    //@NotNull(message = "Las clases no pueden estar vacias")
    @ManyToMany
    @JoinTable(name ="ClasexCompra",
            joinColumns =
                 @JoinColumn (name = "CompraRealizadaID"),
            inverseJoinColumns =
                 @JoinColumn (name = "claseID"))
    private List<ClaseCantidadDTO> clases;

    //@NotNull(message = "Los productos no pueden estar vacios")
    @ManyToMany
    @JoinTable(name ="ProductoxCompra",
            joinColumns =
            @JoinColumn (name = "CompraRealizadaID"),
            inverseJoinColumns =
            @JoinColumn (name = "productoID"))
    private List<Producto> productos;



    public CompraRealizada(){
        super();
        this.fecha = new Date();
        this.clases = new ArrayList<>();
        this.productos = new ArrayList<>();
    }

    public void addProductos(List<Producto> productos) throws JsonProcessingException {
        this.productos.addAll(productos);
        ObjectMapper mapper = new ObjectMapper();
        System.out.println("Productos: " + mapper.writeValueAsString(this.productos));
    }

    public void addClases(List<ClaseCantidadDTO> clases) throws JsonProcessingException {
        this.clases.addAll(clases);
        ObjectMapper mapper = new ObjectMapper();
        System.out.println("Clases: " + mapper.writeValueAsString(this.clases));
    }
}
