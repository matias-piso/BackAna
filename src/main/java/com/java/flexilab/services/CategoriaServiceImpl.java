package com.java.flexilab.services;

import com.java.flexilab.entities.sistem.Categoria;
import com.java.flexilab.interfaces.CategoriaService;
import com.java.flexilab.repositories.BaseRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl extends BaseServiceImpl<Categoria, Integer> implements CategoriaService {
    public CategoriaServiceImpl(BaseRepository<Categoria, Integer> baseRepository) {
        super(baseRepository);
    }
}
