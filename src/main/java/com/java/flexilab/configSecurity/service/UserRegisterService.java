package com.java.flexilab.configSecurity.service;

import com.java.flexilab.configSecurity.model.UserRegister;

public interface  UserRegisterService {

    /**
     * Registra un nuevo usuario.
     *
     * @param userRegistration Los datos de registro del usuario.
     * @return true si el usuario se registra correctamente, false en caso contrario.
     * @throws Exception si ocurre un error durante el registro del usuario.
     */
    boolean registerUser(UserRegister userRegistration, String rol) throws Exception;
}

