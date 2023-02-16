package com.java.flexilab.entities.sistem;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Producto {
    @Id
    @GeneratedValue
    private  Integer id;

    private String nombre ;
    private String descripcion;
    private Integer precioDolar;
    private Integer precioPesos;
    private  String UrlFoto;

    @ManyToOne
    private Categoria categoria;

    public Producto(){
        super();
    }
}
