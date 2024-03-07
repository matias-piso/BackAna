package com.java.flexilab.services;

import com.java.flexilab.entities.sistem.CategoriaProducto;
import com.java.flexilab.interfaces.CategoriaProductoService;
import com.java.flexilab.repositories.BaseRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoriaProductoServiceImpl extends BaseServiceImpl<CategoriaProducto, Integer> implements CategoriaProductoService {
    public CategoriaProductoServiceImpl(BaseRepository<CategoriaProducto, Integer> baseRepository) {
        super(baseRepository);
    }
}
