package com.java.flexilab.entities.sistem;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
