package com.java.flexilab.configSecurity.model;

import lombok.Data;

/**
 * Clase que representa los datos de inicio de sesion de un usuario.
 */
@Data
public class UserLogin {
    private String email;
    private String password;
}