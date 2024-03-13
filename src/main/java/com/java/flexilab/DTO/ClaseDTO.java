package com.java.flexilab.DTO;

import com.java.flexilab.entities.actors.Admin;
import com.java.flexilab.entities.sistem.Categoria;
import com.java.flexilab.entities.sistem.EnumNivel;
import com.java.flexilab.entities.sistem.EnumTipo;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class ClaseDTO {

    private Integer id;
    private String tipo;
    private String nombre;
    private String descripcion;
    private Integer precioDolar;
    private Integer precioPesos;
    private Integer precioEuros;
    private String UrlFoto;
    private Integer visitas;
    private String nivel;
    private Integer cantidad;

    private Date fechaCreacion;

    private Categoria categoria;

    private Admin admin;

    private boolean activo;

    public ClaseDTO() {
    }

    public ClaseDTO(Integer id, String tipo, String nombre, String descripcion, Integer precioDolar, Integer precioPesos, Integer precioEuros, String urlFoto, Integer visitas, String nivel, Integer cantidad, Date fechaCreacion, Categoria categoria, Admin admin, boolean activo) {
        this.id = id;
        this.tipo = tipo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioDolar = precioDolar;
        this.precioPesos = precioPesos;
        this.precioEuros = precioEuros;
        this.UrlFoto = urlFoto;
        this.visitas = visitas;
        this.nivel = nivel;
        this.cantidad = cantidad;
        this.fechaCreacion = fechaCreacion;
        this.categoria = categoria;
        this.admin = admin;
        this.activo = activo;
    }


}
