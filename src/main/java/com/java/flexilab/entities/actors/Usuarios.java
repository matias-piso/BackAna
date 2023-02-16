package com.java.flexilab.entities.actors;

import com.java.flexilab.entities.sistem.CompraRealizada;
import com.java.flexilab.entities.sistem.MetodoPago;
import com.java.flexilab.entities.sistem.Producto;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class Usuarios {
    @Id
    @GeneratedValue
    private  Integer id;
    @Column
    private String usuario ;
    @Column
    private String contrasenia;
    @Column
    private String nombre;
    @Column
    private String pais;

    private MetodoPago metodoPago;

    @OneToMany
    private List<CompraRealizada> comprasRealizadas;


   public Usuarios(){
       super();
       if (pais == "ARGETINA"){
           metodoPago = MetodoPago.MERCADOPAGO;
       }
       else{
           metodoPago = MetodoPago.TRANSFERENCIADOLAR;
       }

   }

}
