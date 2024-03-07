package com.java.flexilab.entities.sistem;

import com.java.flexilab.entities.Base;
import com.java.flexilab.entities.actors.Admin;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Entity;

import java.time.LocalDate;

@Setter
@Getter
@Entity
public class Clases extends Base {
    @NotBlank(message = "El nombre no puede estar vacio")
    @Column
    private String nombre;
    @NotBlank(message = "La descripcion no puede estar vacio")
    @Column
    private String descripcion;
    @NotNull(message = "El precio del dolar no puede estar vacio")
    @Column
    private Integer precioDolar;
    @NotNull(message = "El precio en pesos no puede estar vacio")
    @Column
    private Integer precioPesos;
    @NotNull(message = "El precio en euros no puede estar vacio")
    @Column
    private Integer precioEuros;
    @NotBlank(message = "La url de la foto no puede estar vacio")
    @Column
    private String UrlFoto;
    @Column
    private Integer visitas;
    @NotNull(message = "El nivel no puede estar vacio")
    @Column
    private EnumNivel nivel;

    @Column
    private LocalDate fechaCreacion;

    @NotNull(message = "La categoria no puede estar vacia")
    @ManyToOne
    private Categoria categoria;

    @NotNull(message = "El admin no puede estar vacio")
    @ManyToOne
    private Admin admin;

    public Clases(){
        super();
        this.visitas = 0;
        this.fechaCreacion = LocalDate.now();
    }

    public void sumarVisita(){
        this.visitas++;
    }
}
