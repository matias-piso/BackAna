package com.java.flexilab.entities.sistem;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Setter
@Getter
@Entity
public class ArticulosBlog {

    @Id
    @GeneratedValue
    private Integer id;

    private String urlImagen;
    private String titulo;
    private String video;
    private String subtitulo1;
    private String descripcion1;
    private String subtitulo2;
    private String descripcion2;
    private String subtitulo3;
    private String descripcion3;
    private LocalDate fechaCreacion;

    @ManyToOne
    private CategoriaBlog categoriaBlog;

    public ArticulosBlog(){
        super();
    }


}
