package com.java.flexilab.entities.sistem;

import com.java.flexilab.entities.Base;
import com.java.flexilab.entities.actors.Admin;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter @Getter
@Entity
public class Producto extends Base {
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
    private LocalDate fechaCreacion;

    @NotNull(message = "La categoria no puede estar vacia")
    @ManyToOne
    private CategoriaProducto categoria;

    @NotNull(message = "El admin no puede estar vacio")
    @ManyToOne
    private Admin admin;


    public Producto(String nombre, String descripcion, Integer precioDolar, Integer precioPesos, Integer precioEuros, String urlFoto, CategoriaProducto categoria, Admin admin) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioDolar = precioDolar;
        this.precioPesos = precioPesos;
        this.precioEuros = precioEuros;
        UrlFoto = urlFoto;
        this.categoria = categoria;
        this.admin = admin;
        this.fechaCreacion = LocalDate.now();
    }
    public Producto(){
        super();
        this.fechaCreacion = LocalDate.now();
    }

}
