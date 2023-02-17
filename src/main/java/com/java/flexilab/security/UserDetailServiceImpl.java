package com.java.flexilab.security;

import com.java.flexilab.entities.actors.Usuarios;
import com.java.flexilab.repositories.UsuariosRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UsuariosRepo usuariosRepo;

    @Autowired
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       Usuarios usuarios = UsuariosRepo
                .findoneByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario con email " + email + " no existe"));
                return new UserDetailImpl(usuarios);
    }

}
