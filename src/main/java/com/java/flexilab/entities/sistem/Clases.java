package com.java.flexilab.entities.sistem;

import com.java.flexilab.entities.Base;
import com.java.flexilab.entities.actors.Admin;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Entity;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
public class Clases extends Base {

    private EnumTipo tipo;

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
    private Date fechaCreacion;

    @ManyToMany
    private List<HorarioClase> horariosDisponibles;

    @NotNull(message = "La categoria no puede estar vacia")
    @ManyToOne
    private Categoria categoria;

    @NotNull(message = "El admin no puede estar vacio")
    @ManyToOne
    private Admin admin;


    public Clases(){
        super();
        this.visitas = 0;
        if (this.fechaCreacion == null){
            this.fechaCreacion = new Date();
        }
        this.tipo = EnumTipo.CLASE;
    }

    public void sumarVisita(){
        this.visitas++;
    }

    public Clases (String nombre, String descripcion, Integer precioDolar, Integer precioPesos, Integer precioEuros, String UrlFoto, String nivel, Categoria categoria, Admin admin, String tipo){
        super();
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioDolar = precioDolar;
        this.precioPesos = precioPesos;
        this.precioEuros = precioEuros;
        this.UrlFoto = UrlFoto;
        this.nivel = EnumNivel.valueOf(nivel);
        this.categoria = categoria;
        this.admin = admin;
        this.visitas = 0;
        if (this.fechaCreacion == null){
            this.fechaCreacion = new Date();
        }
        this.tipo = EnumTipo.CLASE;
    }

    public void addHorario(HorarioClase horario){
        this.horariosDisponibles.add(horario);
    }
}
