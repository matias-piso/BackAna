package com.java.flexilab.services;

import com.java.flexilab.configSecurity.model.User;
import com.java.flexilab.configSecurity.model.UserRegister;
import com.java.flexilab.configSecurity.repository.RolRepository;
import com.java.flexilab.configSecurity.service.UserRegisterService;
import com.java.flexilab.configSecurity.service.UserServiceImpl;
import com.java.flexilab.entities.actors.Profesor;
import com.java.flexilab.entities.sistem.Producto;
import com.java.flexilab.interfaces.ProductoService;
import com.java.flexilab.repositories.BaseRepository;
import com.java.flexilab.repositories.ProductoRepo;
import com.java.flexilab.repositories.ProfesorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfesorServiceImpl extends BaseServiceImpl<Profesor, Integer> {

    @Autowired
    private ProfesorRepo profesorRepo;

    @Autowired
    private UserRegisterService userRegisterService;

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ProfesorServiceImpl(BaseRepository<Profesor, Integer> baseRepository) {
        super(baseRepository);
    }

    public boolean registerProfe(UserRegister userRegistration, String roleProfesor) {
        try {
            User user = new User();
            user.setNombre(userRegistration.getNombre());
            user.setEmail(userRegistration.getEmail());
            String encryptedPassword = passwordEncoder.encode(userRegistration.getPassword());
            user.setPassword(encryptedPassword);
            // Asignar el rol de "usuario" al usuario registrado
            rolRepository.findByNombre(roleProfesor).ifPresent(usuarioRol -> user.getRoles().add(usuarioRol));

            Profesor profesor = new Profesor();
            profesor.setUser(user);

            profesorRepo.save(profesor);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void deleteById(Integer id) {
        try {
            Optional<Profesor> prof = profesorRepo.findById(id);
            if (prof.isPresent()) {
                Profesor profesor = prof.get();
                User user = profesor.getUser();
                user.setActivo(false);
                profesor.setUser(user);
                profesor.setActivo(false);
                profesorRepo.save(profesor);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Profesor activarUsuario(Integer idProf) {
        try {
            Optional<Profesor> prof = profesorRepo.findById(idProf);
            if (prof.isPresent()) {
                Profesor profesor = prof.get();
                User user = profesor.getUser();
                user.setActivo(true);
                profesor.setUser(user);
                profesor.setActivo(true);
                return profesorRepo.save(profesor);
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
