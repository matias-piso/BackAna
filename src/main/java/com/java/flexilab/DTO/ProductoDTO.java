package com.java.flexilab.DTO;

import com.java.flexilab.entities.sistem.Categoria;
import com.java.flexilab.entities.sistem.CategoriaProducto;
import com.java.flexilab.entities.sistem.EnumTipo;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter @Setter
public class ProductoDTO {
    private Integer id;
    private boolean activo;
    private String tipo;
    private String nombre;
    private String descripcion;
    private Integer precioDolar;
    private Integer precioPesos;
    private Integer precioEuros;
    private Date fechaCreacion;
    private CategoriaProducto categoria;
    private Integer cantidad;

    public ProductoDTO() {
    }

    public ProductoDTO(boolean activo, String tipo, String nombre, String descripcion, Integer precioDolar, Integer precioPesos, Integer precioEuros, Date fechaCreacion, CategoriaProducto categoria, Integer cantidad) {
        this.activo = activo;
        this.tipo = tipo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioDolar = precioDolar;
        this.precioPesos = precioPesos;
        this.precioEuros = precioEuros;
        this.fechaCreacion = fechaCreacion;
        this.categoria = categoria;
        this.cantidad = cantidad;
    }
}
