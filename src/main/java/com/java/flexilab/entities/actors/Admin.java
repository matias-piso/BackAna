package com.java.flexilab.entities.actors;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Admin {
    @Id
    @GeneratedValue
    private  Integer id;

    private String usuario ;
    private String contrasenia;

    public Admin(){
        super();
    }
}
