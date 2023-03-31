package com.java.flexilab.services;

import com.java.flexilab.entities.sistem.Categoria;
import com.java.flexilab.entities.sistem.EnumNivel;
import com.java.flexilab.entities.sistem.EnumPack;
import com.java.flexilab.entities.sistem.Producto;
import com.java.flexilab.interfaces.ProductoService;
import com.java.flexilab.repositories.BaseRepository;
import com.java.flexilab.repositories.CategoriaRepo;
import com.java.flexilab.repositories.ProductoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl extends BaseServiceImpl<Producto, Integer> implements ProductoService {
    @Autowired
    public ProductoRepo productoRepo;
    @Autowired
    public CategoriaRepo categoriaRepo;

    public ProductoServiceImpl(BaseRepository<Producto, Integer> baseRepository) {
        super(baseRepository);
    }

    public Page<Producto> findByCategoriaAndNivel(String categoria, EnumNivel nivel, Pageable pageable) {
        Categoria cat = categoriaRepo.findByNombre(categoria);
        return productoRepo.findByCategoriaAndNivel(cat, nivel, pageable);
    }

    public Page<Producto> findByCategoria(String categoria, Pageable pageable) {
        Categoria cat = categoriaRepo.findByNombre(categoria);
        return productoRepo.findByCategoria(cat, pageable);
    }

    public Page<Producto> findByNivel(EnumNivel nivel, Pageable pageable) {
        return productoRepo.findByNivel(nivel, pageable);
    }

    public Page<Producto> findByCategoriaAndNivelAndPack(String categoria, EnumNivel nivel, EnumPack pack, Pageable pageable) {
        Categoria cat = categoriaRepo.findByNombre(categoria);
        return productoRepo.findByCategoriaAndNivelAndPack(cat, nivel, pack, pageable);
    }

    public Page<Producto> findByPack(EnumPack pack, Pageable pageable) {
        return productoRepo.findByPack(pack, pageable);
    }

    public Page<Producto> findByCategoriaAndPack(String categoria, EnumPack pack, Pageable pageable) {
        Categoria cat = categoriaRepo.findByNombre(categoria);
        return productoRepo.findByCategoriaAndPack(cat, pack, pageable);
    }

    public Page<Producto> findByNivelAndPack(EnumNivel nivel, EnumPack pack, Pageable pageable) {
        return productoRepo.findByNivelAndPack(nivel, pack, pageable);
    }

}
