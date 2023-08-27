package com.java.flexilab.configSecurity.service;

import org.springframework.stereotype.Service;

import com.java.flexilab.configSecurity.model.User;
import com.java.flexilab.repositories.BaseRepository;
import com.java.flexilab.services.BaseServiceImpl;

/**
 * Implementación del servicio de usuarios.
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User, Integer> {

    /**
     * Constructor de UsuarioServiceImpl.
     *
     * @param baseRepository El repositorio base para la entidad Usuario.
     */
    public UserServiceImpl(BaseRepository<User, Integer> baseRepository) {
        super(baseRepository);
    }

}