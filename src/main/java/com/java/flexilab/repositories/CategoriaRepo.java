package com.java.flexilab.repositories;


import com.java.flexilab.entities.actors.Admin;
import com.java.flexilab.entities.sistem.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepo extends BaseRepository<Categoria, Integer>  {
    public Categoria findByNombre(String categoria);
}
