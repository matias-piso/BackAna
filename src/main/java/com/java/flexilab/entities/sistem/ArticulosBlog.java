package com.java.flexilab.entities.sistem;

import com.java.flexilab.DTO.AdminDTO;
import com.java.flexilab.entities.Base;
import com.java.flexilab.entities.actors.Admin;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Setter
@Getter
@Entity
public class ArticulosBlog extends Base {

    @NotBlank(message = "El url de la imagen no puede estar vacio")
    @Column
    private String urlImagen;
    @NotBlank(message = "El titulo no puede estar vacio")
    @Column
    private String titulo;
    @NotBlank(message = "El video no puede estar vacio")
    @Column
    private String video;
    @NotBlank(message = "La breve introduccion no puede estar vacio")
    @Column
    private String breveIntroduccion;
    @NotBlank(message = "El subtitulo 1 no puede estar vacio")
    @Column
    private String subtitulo1;
    @NotBlank(message = "La descripcion 1 no puede estar vacio")
    @Column
    private String descripcion1;
    @NotBlank(message = "El subtitulo 2 no puede estar vacio")
    @Column
    private String subtitulo2;
    @NotBlank(message = "La descripcion 2 no puede estar vacio")
    @Column
    private String descripcion2;
    @NotBlank(message = "El subtitulo 3 no puede estar vacio")
    @Column
    private String subtitulo3;

    @NotBlank(message = "La descripcion 3 no puede estar vacio")
    @Column
    private String descripcion3;
    @Column
    private LocalDate fechaCreacion;

    @NotNull(message = "La categoria no puede estar vacia")
    @ManyToOne
    private CategoriaBlog categoriaBlog;

    @NotNull(message = "El admin no puede estar vacio")
    @ManyToOne
    private Admin admin;

    public ArticulosBlog(){
        super();
        this.fechaCreacion = LocalDate.now();
    }


}
