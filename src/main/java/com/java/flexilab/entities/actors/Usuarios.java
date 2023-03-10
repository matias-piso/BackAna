package com.java.flexilab.entities.actors;

import com.java.flexilab.entities.Base;
import com.java.flexilab.entities.sistem.CompraRealizada;
import com.java.flexilab.entities.sistem.MetodoPago;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class Usuarios extends Base {
    @Column
    private String email ;
    @Column
    private String password;
    @Column
    private String nombre;
    @Column
    private String pais;
    @Column
    private MetodoPago metodoPago;

    @OneToMany
    private List<CompraRealizada> comprasRealizadas;


   public Usuarios(){
       super();
       /*
       if (this.pais.toUpperCase() == "ARGENTINA"){
           this.metodoPago = MetodoPago.MERCADOPAGO;
       }
       else{
           this.metodoPago = MetodoPago.TRANSFERENCIADOLAR;
       }
        */

   }

}
