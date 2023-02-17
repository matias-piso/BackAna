package com.java.flexilab.entities.actors;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import com.java.flexilab.entities.Base;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Admin extends Base {
    @Column
    private String usuario ;
    @Column
    private String contrasenia;


    public Admin(){
        super();
    }
}
