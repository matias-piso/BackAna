package com.java.flexilab.repositories;

import com.java.flexilab.entities.actors.Admin;
import com.java.flexilab.entities.actors.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuariosRepo extends BaseRepository<Usuarios, Integer>  {

    Usuarios findByEmail(String email);

}
