package com.java.flexilab.entities.actors;

import com.java.flexilab.entities.sistem.CompraRealizada;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Usuarios {
    @Id
    @GeneratedValue
    private  Integer id;

    private String usuario ;
    private String contrasenia;
    private String nombre;
    @ManyToOne
    private CompraRealizada comprasRealizadas;

   public Usuarios(){
       super();
   }

}
