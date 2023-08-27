package com.java.flexilab.configSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.flexilab.configSecurity.model.Rol;

import java.util.Optional;

/**
 * Repositorio para la entidad Rol.
 */
@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {

    /**
     * Busca un rol por su nombre.
     *
     * @param nombre El nombre del rol a buscar.
     * @return Una instancia de Optional que contiene el rol encontrado, o vacío si no se encuentra.
     */
    Optional<Rol> findByNombre(String nombre);
}