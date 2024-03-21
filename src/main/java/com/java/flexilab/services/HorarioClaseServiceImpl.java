package com.java.flexilab.services;

import com.java.flexilab.entities.sistem.HorarioClase;
import com.java.flexilab.entities.sistem.Producto;
import com.java.flexilab.interfaces.ProductoService;
import com.java.flexilab.repositories.BaseRepository;
import com.java.flexilab.repositories.ProductoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HorarioClaseServiceImpl extends BaseServiceImpl<HorarioClase, Integer> {
    public HorarioClaseServiceImpl(BaseRepository<HorarioClase, Integer> baseRepository) {
        super(baseRepository);
    }
}

