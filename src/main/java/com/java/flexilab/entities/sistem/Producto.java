package com.java.flexilab.entities.sistem;

import com.java.flexilab.entities.actors.Admin;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.List;

@Setter
@Getter
@Entity
public class Producto {
    @Id
    @GeneratedValue
    private  Integer id;
    @Column
    private String nombre ;
    @Column
    private String descripcion;
    @Column
    private Integer precioDolar;
    @Column
    private Integer precioPesos;
    @Column
    private  String UrlFoto;

    @ManyToOne
    private Categoria categoria;

    @ManyToOne
    private Admin admin;


    public Producto(){
        super();
    }
}
