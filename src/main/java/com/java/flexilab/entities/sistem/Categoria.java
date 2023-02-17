package com.java.flexilab.entities.sistem;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import com.java.flexilab.entities.Base;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Categoria extends Base {
    @Column
    private String nombre;
    @Column
    private String descripcion;
    @Column
    private String urlImagen;

    public Categoria(){

        super();
    }
}
