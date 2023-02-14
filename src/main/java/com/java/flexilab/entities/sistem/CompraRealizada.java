package com.java.flexilab.entities.sistem;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
public class CompraRealizada {
    @Id
    @GeneratedValue
    private Integer id;

    private List<Producto> productos;
    private LocalDate fecha;
    private LocalTime hora;
    private Integer precio;


}
