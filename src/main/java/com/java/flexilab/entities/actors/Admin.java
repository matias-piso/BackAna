package com.java.flexilab.entities.actors;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import com.java.flexilab.entities.Base;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Admin extends Base {
    @NotBlank(message = "El nombre no puede estar vacio")
    @Column
    private String usuario;
    @NotBlank(message = "La contraseña no puede estar vacia")
    @Column
    private String contrasenia;


    public Admin(){
        super();
    }
}
