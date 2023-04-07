package com.java.flexilab.entities.actors;

import com.java.flexilab.entities.Base;
import com.java.flexilab.entities.sistem.CompraRealizada;
import com.java.flexilab.entities.sistem.EnumMetodoPago;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class Usuarios extends Base {
    @NotBlank(message = "El nombre no puede estar vacio")
    @Column
    private String email;
    @NotBlank(message = "La contraseña no puede estar vacia")
    @Column
    private String password;
    @NotBlank(message = "El nombre no puede estar vacio")
    @Column
    private String nombre;
    @NotBlank(message = "El pais no puede estar vacio")
    @Column
    private String pais;
    @NotBlank(message = "El metodo de pago no puede estar vacio")
    @Column
    private EnumMetodoPago metodoPago;

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
