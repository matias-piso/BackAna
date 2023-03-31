package com.java.flexilab.repositories;


import com.java.flexilab.entities.actors.Admin;
import com.java.flexilab.entities.sistem.Categoria;
import com.java.flexilab.entities.sistem.EnumNivel;
import com.java.flexilab.entities.sistem.EnumPack;
import com.java.flexilab.entities.sistem.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepo extends BaseRepository<Producto, Integer>  {
    Page<Producto> findByCategoria(Categoria cat, Pageable pageable);

    Page<Producto> findByNivel(EnumNivel nivel, Pageable pageable);

    Page<Producto> findByCategoriaAndNivel(Categoria categoria, EnumNivel nivel, Pageable pageable);

    Page<Producto> findByCategoriaAndNivelAndPack(Categoria categoria, EnumNivel nivel, EnumPack pack, Pageable pageable);

    Page<Producto> findByPack(EnumPack pack, Pageable pageable);

    Page<Producto> findByCategoriaAndPack(Categoria categoria, EnumPack pack, Pageable pageable);

    Page<Producto> findByNivelAndPack(EnumNivel nivel, EnumPack pack, Pageable pageable);
}
