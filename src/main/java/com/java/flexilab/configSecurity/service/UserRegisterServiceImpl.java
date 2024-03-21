package com.java.flexilab.configSecurity.service;

import com.java.flexilab.entities.actors.Usuarios;
import com.java.flexilab.repositories.UsuariosRepo;
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
    private UserRepository usuarioRepository;

    @Autowired
    private UsuariosRepo usuarioRepo;

    @Autowired
    private UserDetailsService userDetailsService;

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

    public boolean registerUser(UserRegister userRegistration, String rol) throws Exception {
        // Verificar si el correo electrónico ya está registrado
        if (usuarioRepository.findOneByEmail(userRegistration.getEmail()).isPresent()) {
            throw new Exception("El mail ya esta registrado.");
        }

        // Creo un nuevo usuario
        User user = new User();
        user.setNombre(userRegistration.getNombre());
        user.setEmail(userRegistration.getEmail());
        user.setActivo(true);

        // Encriptar la contraseña utilizando BCrypt
        String encryptedPassword = passwordEncoder.encode(userRegistration.getPassword());
        user.setPassword(encryptedPassword);

        // Asignar el rol de "usuario" al usuario registrado
        rolRepository.findByNombre(rol).ifPresent(usuarioRol -> user.getRoles().add(usuarioRol));

        // Guardar el usuario en la base de datos
        usuarioRepository.save(user);

        try {
            usuarioRepo.save(new Usuarios(user));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error al registrar el usuario en el sistema.");
        }

        // Cargar el usuario recién registrado en el sistema de Spring Security
        UserDetails userDetails = userDetailsService.loadUserByUsername(user.getEmail());
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return true;
    }
}