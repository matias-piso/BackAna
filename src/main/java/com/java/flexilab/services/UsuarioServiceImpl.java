package com.java.flexilab.services;

import com.java.flexilab.entities.actors.Admin;
import com.java.flexilab.interfaces.AdminService;
import com.java.flexilab.repositories.BaseRepository;
import org.springframework.stereotype.Service;


@Service
public class UsuarioServiceImpl extends BaseServiceImpl<Admin, Integer> implements AdminService {

    public UsuarioServiceImpl(BaseRepository<Admin, Integer> baseRepository) {
        super(baseRepository);
    }

}
