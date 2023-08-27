package com.java.flexilab.configSecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.java.flexilab.configSecurity.model.User;
import com.java.flexilab.configSecurity.repository.UserRepository;

/**
 * Implementación de UserDetailsService para cargar los detalles del usuario a partir del nombre de usuario (email).
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    /**
     * Carga los detalles del usuario a partir del nombre de usuario (email).
     *
     * @param email El nombre de usuario (email) del usuario.
     * @return Los detalles del usuario.
     * @throws UsernameNotFoundException Si no se encuentra el usuario con el nombre de usuario (email) especificado.
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository
                .findOneByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));

        // Crear una instancia de UserDetailsImpl con el usuario encontrado
        return new UserDetailsImpl(user);
    }
}