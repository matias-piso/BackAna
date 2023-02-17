package com.java.flexilab.repositories;

import com.java.flexilab.entities.sistem.CompraRealizada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRealizadaRepo extends JpaRepository<CompraRealizada,Integer> {
}
