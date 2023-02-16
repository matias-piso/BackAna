package com.java.flexilab.entities.actors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Admin {
    @Id
    @GeneratedValue
    private  Integer id;
    @Column
    private String usuario ;
    @Column
    private String contrasenia;


    public Admin(){
        super();
    }
}
