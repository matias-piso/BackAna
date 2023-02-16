package com.java.flexilab.entities.sistem;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Categoria {
    @Id
    @GeneratedValue
    private Integer id;

    private String nombre;
    private String descripcion;
    private String urlImagen;

    public Categoria(){

        super();
    }
}
