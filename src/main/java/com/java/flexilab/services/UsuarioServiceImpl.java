package com.java.flexilab.services;

import com.java.flexilab.configSecurity.model.User;
import com.java.flexilab.configSecurity.repository.UserRepository;
import com.java.flexilab.entities.actors.Usuarios;
import com.java.flexilab.interfaces.UsuarioService;
import com.java.flexilab.repositories.BaseRepository;
import com.java.flexilab.repositories.UsuariosRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl extends BaseServiceImpl<Usuarios, Integer> implements UsuarioService {


    @Autowired
    private UsuariosRepo usuariosRepository;

/*
    @Autowired
    private UserRepository userRepository;
*/
    public UsuarioServiceImpl(BaseRepository<Usuarios, Integer> baseRepository) {
        super(baseRepository);
    }


    public Usuarios findByEmail(String email) {
        Usuarios usu = usuariosRepository.findByUserEmail(email);
        System.out.println("User: " + usu);
        System.out.println("Email: " + email);
        return usu;
    }

    /*
    public Optional<User> findByEmail2(String email) {
        Optional<User> usu = userRepository.findOneByEmail(email);
        System.out.println("User2: " + usu);
        System.out.println("Email2: " + email);
        return usu;
    }

    public Usuarios findById(Integer id) {
        return (Usuarios) usuariosRepository.findById(id).orElse(null);
    }

*/
}
