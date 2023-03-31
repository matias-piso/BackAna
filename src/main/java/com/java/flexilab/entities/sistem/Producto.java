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
    private Integer precioEuros;
    @Column
    private String UrlFoto;
    @Column
    private Integer visitas;
    @Column
    private EnumNivel nivel;
    @Column
    private EnumPack pack;

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
