package com.java.flexilab.entities.sistem;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import com.java.flexilab.entities.Base;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Categoria extends Base {
    @NotBlank(message = "El nombre no puede estar vacio")
    @Column
    private String nombre;
    @NotBlank(message = "La descripcion no puede estar vacio")
    @Column
    private String descripcion;
    @NotBlank(message = "El url de la imagen no puede estar vacio")
    @Column
    private String urlImagen;

    public Categoria(){
        super();
    }

    public Categoria(String nombre, String descripcion, String urlImagen){
        super();
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.urlImagen = urlImagen;
    }
}
