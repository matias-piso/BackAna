package com.java.flexilab.entities.actors;

import com.java.flexilab.configSecurity.model.Rol;
import com.java.flexilab.configSecurity.model.User;
import com.java.flexilab.entities.Base;
import com.java.flexilab.entities.sistem.Aula;
import com.java.flexilab.entities.sistem.CompraRealizada;
import com.java.flexilab.entities.sistem.EnumMetodoPago;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "usuarios")
public class Usuarios extends Base{

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    //@NotBlank(message = "El pais no puede estar vacio")
    @Column
    private String pais;
    //@NotBlank(message = "El metodo de pago no puede estar vacio")
    @Column
    private EnumMetodoPago metodoPago;

    @OneToMany
    private List<CompraRealizada> comprasRealizadas;

    @ManyToOne
    @JoinColumn(name = "aula_id")
    private Aula aula;

   public Usuarios(){
       super();
   }

   public Usuarios(User user){
       super();
       this.user = user;
       this.pais = null;
       this.metodoPago = null;
       this.comprasRealizadas = new ArrayList<>();

   }

    public void addCompraRealizada(CompraRealizada compraRealizada) {
        this.comprasRealizadas.add(compraRealizada);
    }

    public void removeCompraRealizada(CompraRealizada compraRealizada) {
        this.comprasRealizadas.remove(compraRealizada);
    }

    public void setUserNombreEmail(String nombre, String email) {
        this.user.setNombre(nombre);
        this.user.setEmail(email);
    }
}
