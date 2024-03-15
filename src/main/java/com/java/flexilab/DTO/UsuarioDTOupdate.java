package com.java.flexilab.DTO;

import com.java.flexilab.configSecurity.model.User;
import com.java.flexilab.entities.Base;
import com.java.flexilab.entities.sistem.CompraRealizada;
import com.java.flexilab.entities.sistem.EnumMetodoPago;
import com.java.flexilab.entities.sistem.Producto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter @Getter
@NoArgsConstructor
public class UsuarioDTOupdate extends Base {

    private Integer id;

    private User user;

//    private List<CompraRealizadaDTO> comprasRealizadasDTO;

}
