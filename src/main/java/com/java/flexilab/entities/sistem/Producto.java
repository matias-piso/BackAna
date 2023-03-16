package com.java.flexilab.entities.sistem;

import com.java.flexilab.entities.Base;
import com.java.flexilab.entities.actors.Admin;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Entity;

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

    private Integer visitas;

    @ManyToOne
    private Categoria categoria;

    @ManyToOne
    private Admin admin;

    public Producto(){
        super();
        this.visitas = 0;
    }

    public void sumarVisita(){
        this.visitas++;
    }
}
