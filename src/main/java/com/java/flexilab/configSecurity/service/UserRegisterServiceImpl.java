package com.java.flexilab.configSecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.java.flexilab.configSecurity.model.User;
import com.java.flexilab.configSecurity.model.UserRegister;
import com.java.flexilab.configSecurity.repository.RolRepository;
import com.java.flexilab.configSecurity.repository.UserRepository;

/**
 * Implementación del servicio de registro de usuarios.
 */
@Service
public class UserRegisterServiceImpl implements UserRegisterService {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private UserRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Registra un nuevo usuario en el sistema.
     *
     * @param userRegistration Objeto que contiene los datos de registro del usuario.
     * @return true si el usuario se registró correctamente, false en caso contrario.
     * @throws Exception si ocurre un error durante el registro del usuario.
     */
    @Override
    public boolean registerUser(UserRegister userRegistration) throws Exception {
        // Verificar si el correo electrónico ya está registrado
        if (usuarioRepository.findOneByEmail(userRegistration.getEmail()).isPresent()) {
            throw new Exception("El mail ya esta registrado.");
        }

        // Creo un nuevo usuario
        User usuario = new User();
        usuario.setNombre(userRegistration.getNombre());
        usuario.setEmail(userRegistration.getEmail());

        // Encriptar la contraseña utilizando BCrypt
        String encryptedPassword = passwordEncoder.encode(userRegistration.getPassword());
        usuario.setPassword(encryptedPassword);

        // Asignar el rol de "usuario" al usuario registrado
        rolRepository.findByNombre("usuario").ifPresent(usuarioRol -> usuario.getRoles().add(usuarioRol));

        // Guardar el usuario en la base de datos
        usuarioRepository.save(usuario);

        // Cargar el usuario recién registrado en el sistema de Spring Security
        UserDetails userDetails = userDetailsService.loadUserByUsername(usuario.getEmail());
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return true;
    }
}