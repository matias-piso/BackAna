package com.java.flexilab.entities.sistem;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

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
}
