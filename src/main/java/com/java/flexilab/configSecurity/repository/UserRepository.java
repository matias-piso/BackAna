package com.java.flexilab.configSecurity.repository;

import org.springframework.stereotype.Repository;

import com.java.flexilab.configSecurity.model.User;
import com.java.flexilab.repositories.BaseRepository;

import java.util.Optional;

/**
 * Repositorio para la entidad Usuario.
 */
@Repository
public interface UserRepository extends BaseRepository<User, Integer> {

    /**
     * Busca un usuario por su correo electrónico.
     *
     * @param email El correo electrónico del usuario a buscar.
     * @return Una instancia de Optional que contiene el usuario encontrado, o vacío si no se encuentra.
     */
    Optional<User> findOneByEmail(String email);
}