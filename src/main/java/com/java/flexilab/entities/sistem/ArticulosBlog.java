package com.java.flexilab.entities.sistem;

import com.java.flexilab.DTO.AdminDTO;
import com.java.flexilab.entities.Base;
import com.java.flexilab.entities.actors.Admin;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Setter
@Getter
@Entity
public class ArticulosBlog extends Base {

    @Column
    private String urlImagen;
    @Column
    private String titulo;
    @Column
    private String video;
    @Column
    private String breveIntroduccion;
    @Column
    private String subtitulo1;
    @Column
    private String descripcion1;
    @Column
    private String subtitulo2;
    @Column
    private String descripcion2;
    @Column
    private String subtitulo3;
    @Column
    private String descripcion3;
    @Column
    private LocalDate fechaCreacion;

    @ManyToOne
    private CategoriaBlog categoriaBlog;

    @ManyToOne
    private Admin admin;

    public ArticulosBlog(){
        super();
        this.fechaCreacion = LocalDate.now();
    }


}
