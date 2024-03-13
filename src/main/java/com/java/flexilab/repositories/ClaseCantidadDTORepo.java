package com.java.flexilab.repositories;

import com.java.flexilab.DTO.ClaseCantidadDTO;
import com.java.flexilab.entities.sistem.CompraRealizada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaseCantidadDTORepo extends JpaRepository<ClaseCantidadDTO, Integer> {
}
