package com.java.flexilab.services;

import com.java.flexilab.entities.sistem.Producto;
import com.java.flexilab.interfaces.ProductoService;
import com.java.flexilab.repositories.BaseRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl extends BaseServiceImpl<Producto, Integer> implements ProductoService {
    public ProductoServiceImpl(BaseRepository<Producto, Integer> baseRepository) {
        super(baseRepository);
    }
}
