package com.java.flexilab.entities.sistem;

import jakarta.persistence.*;

import com.java.flexilab.entities.Base;
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
