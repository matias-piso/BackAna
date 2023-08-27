package com.java.flexilab.configSecurity.model;

import lombok.Data;

/**
 * Clase que representa los datos de registro de un usuario.
 */
@Data
public class UserRegister {
    private String nombre;
    private String email;
    private String password;
}