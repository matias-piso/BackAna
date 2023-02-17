package com.java.flexilab.services;

import com.java.flexilab.entities.sistem.CompraRealizada;
import com.java.flexilab.interfaces.CompraRealizadaService;
import com.java.flexilab.repositories.BaseRepository;
import org.springframework.stereotype.Service;

@Service
public class CompraRealizadaServiceImpl extends BaseServiceImpl<CompraRealizada, Integer> implements CompraRealizadaService {
    public CompraRealizadaServiceImpl(BaseRepository<CompraRealizada, Integer> baseRepository) {
        super(baseRepository);
    }
}
