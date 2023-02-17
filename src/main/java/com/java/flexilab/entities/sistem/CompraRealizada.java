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
    @Column
    private LocalDate fecha;
    @Column
    private LocalTime hora;
    @Column
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
