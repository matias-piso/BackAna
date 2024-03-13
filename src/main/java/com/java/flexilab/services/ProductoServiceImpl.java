package com.java.flexilab.services;

import com.java.flexilab.entities.sistem.Producto;
import com.java.flexilab.interfaces.ProductoService;
import com.java.flexilab.repositories.BaseRepository;
import com.java.flexilab.repositories.ProductoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl extends BaseServiceImpl<Producto, Integer> implements ProductoService {

    @Autowired
    private ProductoRepo productoRepo;

    public ProductoServiceImpl(BaseRepository<Producto, Integer> baseRepository) {
        super(baseRepository);
    }

    public Page<Producto> findByCategoria(String nomCategoria, Pageable pageable) {
        return productoRepo.findByCategoriaNombre(nomCategoria, pageable);
    }

}
