package com.java.flexilab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepo extends JpaRepository <UsuariosRepo,Integer>{
}
