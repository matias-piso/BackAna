package com.java.flexilab.entities.sistem;

import jakarta.persistence.*;

import com.java.flexilab.entities.Base;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
@Setter
@Getter
@Entity
public class CompraRealizada extends Base {

    @Column
    private LocalDate fecha;
    @Column
    private LocalTime hora;
    @NotNull(message = "El precio no puede estar vacio")
    @Column
    private Integer precio;

    @NotNull(message = "Los productos no pueden estar vacios")
    @ManyToMany
    @JoinTable(name ="ProductoxCompra",
            joinColumns =
                 @JoinColumn (name = "CompraRealizadaID"),
            inverseJoinColumns =
                 @JoinColumn (name = "ProductoID"))
    private List<Clases> producto;


    public CompraRealizada(){
        super();
        this.fecha = LocalDate.now();
        this.hora = LocalTime.now();
    }
}
