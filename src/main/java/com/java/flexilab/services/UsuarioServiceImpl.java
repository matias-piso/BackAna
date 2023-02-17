package com.java.flexilab.services;

import com.java.flexilab.entities.actors.Admin;
import com.java.flexilab.entities.actors.Usuarios;
import com.java.flexilab.interfaces.AdminService;
import com.java.flexilab.interfaces.UsuarioService;
import com.java.flexilab.repositories.BaseRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl extends BaseServiceImpl<Usuarios, Integer> implements UsuarioService {

    public UsuarioServiceImpl(BaseRepository<Usuarios, Integer> baseRepository) {
        super(baseRepository);
    }

}
