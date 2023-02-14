package com.java.flexilab.entities.actors;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Admin {
    @Id
    @GeneratedValue
    private  Integer id;

    private String usuario ;
    private String contrasenia;
}
