package com.java.flexilab.entities.actors;

import com.java.flexilab.entities.sistem.CompraRealizada;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Usuarios {
    @Id
    @GeneratedValue
    private  Integer id;

    private String usuario ;
    private String contrasenia;
    private String nombre;
    private CompraRealizada comprasRealizadas;
}
