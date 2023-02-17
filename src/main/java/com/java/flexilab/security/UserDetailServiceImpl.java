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

    // Este método se utiliza para cargar los detalles del usuario en el objeto UserDetails de Spring Security
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Busca al usuario en la base de datos a través de su email
        Usuarios usuarios = usuariosRepo
                .findOneByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario con email " + email + " no existe"));
        // Devuelve un objeto UserDetailImpl, que implementa UserDetails y contiene la información del usuario encontrado
        return new UserDetailImpl(usuarios);
    }
}
