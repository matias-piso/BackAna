package com.java.flexilab.entities.sistem;

import javax.persistence.Column;
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
