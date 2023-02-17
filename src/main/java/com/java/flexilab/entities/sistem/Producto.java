package com.java.flexilab.entities.sistem;

import com.java.flexilab.entities.Base;
import com.java.flexilab.entities.actors.Admin;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Entity;
import java.util.List;

@Setter
@Getter
@Entity
public class Producto extends Base {

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
