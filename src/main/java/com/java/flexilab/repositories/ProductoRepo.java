package com.java.flexilab.repositories;

import com.java.flexilab.entities.sistem.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductoRepo extends BaseRepository<Producto, Integer>{

    Page<Producto> findByCategoriaNombre(String nombreCategoria, Pageable pageable);

}
