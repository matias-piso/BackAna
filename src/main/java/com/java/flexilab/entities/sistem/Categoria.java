package com.java.flexilab.entities.sistem;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Categoria {
    @Id
    @GeneratedValue
    private Integer id;

    private String nombre;
    private String descripcion;
    private String urlImagen;
}
