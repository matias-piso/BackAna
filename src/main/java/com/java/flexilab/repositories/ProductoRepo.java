package com.java.flexilab.repositories;


import com.java.flexilab.entities.actors.Admin;
import com.java.flexilab.entities.sistem.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepo extends BaseRepository<Producto, Integer>  {
}
