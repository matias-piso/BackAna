package com.java.flexilab.repositories;

import com.java.flexilab.entities.actors.Usuarios;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuariosRepo extends BaseRepository<Usuarios, Integer> {
    Page<Usuarios> findAllByActivo(Pageable pageable, boolean activo);
    Usuarios findByUserEmail(String email);

}
