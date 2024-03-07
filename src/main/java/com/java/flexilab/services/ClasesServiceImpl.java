package com.java.flexilab.services;

import com.java.flexilab.entities.sistem.Categoria;
import com.java.flexilab.entities.sistem.EnumNivel;
import com.java.flexilab.entities.sistem.Clases;
import com.java.flexilab.interfaces.ClasesService;
import com.java.flexilab.repositories.BaseRepository;
import com.java.flexilab.repositories.CategoriaRepo;
import com.java.flexilab.repositories.ClasesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClasesServiceImpl extends BaseServiceImpl<Clases, Integer> implements ClasesService {
    @Autowired
    public ClasesRepo clasesRepo;
    @Autowired
    public CategoriaRepo categoriaRepo;

    public ClasesServiceImpl(BaseRepository<Clases, Integer> baseRepository) {
        super(baseRepository);
    }

    public Page<Clases> findByCategoriaAndNivel(String categoria, EnumNivel nivel, Pageable pageable) {
        Categoria cat = categoriaRepo.findByNombre(categoria);
        return clasesRepo.findByCategoriaAndNivel(cat, nivel, pageable);
    }

    public Page<Clases> findByCategoria(String categoria, Pageable pageable) {
        Categoria cat = categoriaRepo.findByNombre(categoria);
        return clasesRepo.findByCategoria(cat, pageable);
    }

    public Page<Clases> findByNivel(EnumNivel nivel, Pageable pageable) {
        return clasesRepo.findByNivel(nivel, pageable);
    }

}
