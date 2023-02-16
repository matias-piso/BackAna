package com.java.flexilab.entities.sistem;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
@Setter
@Getter
@Entity
public class CompraRealizada {
    @Id
    @GeneratedValue
    private Integer id;

    private LocalDate fecha;
    private LocalTime hora;
    private Integer precio;

    @ManyToMany
    @JoinTable(name ="ProductoxCompra",
            joinColumns =
                 @JoinColumn (name = "CompraRealizadaID"),
            inverseJoinColumns =
                 @JoinColumn (name = "ProductoID"))
    private List<Producto> producto;


    public CompraRealizada(){
        super();
    }
}
