package com.java.flexilab.entities.sistem;

import com.java.flexilab.DTO.AdminDTO;
import com.java.flexilab.entities.actors.Admin;
import javax.persistence.*;
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
    @Column
    private String urlImagen;
    @Column
    private String titulo;
    @Column
    private String video;
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
    }


}
