package com.java.flexilab.services;

import com.java.flexilab.entities.actors.Admin;
import com.java.flexilab.entities.actors.Usuarios;
import com.java.flexilab.interfaces.AdminService;
import com.java.flexilab.interfaces.UsuarioService;
import com.java.flexilab.repositories.BaseRepository;
import com.java.flexilab.repositories.UsuariosRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl extends BaseServiceImpl<Usuarios, Integer> implements UsuarioService {

    @Autowired
    private UsuariosRepo usuarioRepository;

    public UsuarioServiceImpl(BaseRepository<Usuarios, Integer> baseRepository) {
        super(baseRepository);
    }

    public Usuarios findByEmail(String email) {
        Usuarios usuario = usuarioRepository.findByEmail(email);
        System.out.println("Usuario: " + usuario);
        System.out.println("Email: " + email);
        return usuario;
    }

}
