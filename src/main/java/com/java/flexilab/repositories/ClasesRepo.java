package com.java.flexilab.repositories;


import com.java.flexilab.entities.sistem.Categoria;
import com.java.flexilab.entities.sistem.EnumNivel;
import com.java.flexilab.entities.sistem.Clases;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClasesRepo extends BaseRepository<Clases, Integer>  {
    Page<Clases> findByCategoria(Categoria cat, Pageable pageable);

    Page<Clases> findByNivel(EnumNivel nivel, Pageable pageable);

    Page<Clases> findByCategoriaAndNivel(Categoria categoria, EnumNivel nivel, Pageable pageable);

    List<Clases> findByIdIn(List<Integer> ids);

}
