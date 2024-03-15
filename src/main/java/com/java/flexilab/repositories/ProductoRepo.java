package com.java.flexilab.repositories;

import com.java.flexilab.entities.sistem.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductoRepo extends BaseRepository<Producto, Integer>{

    Page<Producto> findByCategoriaNombre(String nombreCategoria, Pageable pageable);

    List<Producto> findByIdIn(List<Integer> ids);

}
