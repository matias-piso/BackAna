package com.java.flexilab.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.flexilab.DTO.ClaseCantidadDTO;
import com.java.flexilab.DTO.CompraRealizadaDTO;
import com.java.flexilab.DTO.UsuarioDTOupdate;
import com.java.flexilab.configSecurity.model.User;
import com.java.flexilab.configSecurity.service.UserServiceImpl;
import com.java.flexilab.entities.actors.Usuarios;
import com.java.flexilab.entities.sistem.*;
import com.java.flexilab.repositories.UsuariosRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UsuarioServiceImpl {

    @Autowired
    private UsuariosRepo usuariosRepository;

    @Autowired
    private UserServiceImpl userService;


    public Usuarios findByEmail(String email) {
        Usuarios usu = usuariosRepository.findByUserEmail(email);
        System.out.println("User: " + usu);
        System.out.println("Email: " + email);
        return usu;
    }

    public Page<Usuarios> findAll(Pageable pageable, boolean activo){
        try {
            return usuariosRepository.findAllByActivo(pageable, activo);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Transactional
    public Usuarios addCompraRealizada(Integer id, CompraRealizada compraRealizada) {
        try {
            System.out.println("INTENTANDO GUARDAR COMPRA");
            Usuarios usuario = usuariosRepository.findById(id).get();
            System.out.println("obtengo Usuario: " + usuario);
            usuario.addCompraRealizada(compraRealizada);
            ObjectMapper mapper = new ObjectMapper();
            System.out.println("Agrego compra" + mapper.writeValueAsString(usuario.getComprasRealizadas()));
            return usuariosRepository.save(usuario);
        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    public Usuarios findById(Integer id) {
        try {
            Optional<Usuarios> optional = usuariosRepository.findById(id);
            return optional.isPresent() ? optional.get() : null;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void deleteById(Integer id) {
        try {
            usuariosRepository.findById(id).ifPresent(usuarios -> {
                // seteo user activo en false
                User user = usuarios.getUser();
                user.setActivo(false);
                usuarios.setUser(user);
                // seteo usuario activo en false
                usuarios.setActivo(false);
                usuariosRepository.save(usuarios);
            });
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Transactional
    public Usuarios updateById(Integer id, UsuarioDTOupdate usuarioUpdate) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            Optional<Usuarios> entityOptional = usuariosRepository.findById(id);
            Usuarios usuario = entityOptional.get();
            if (!entityOptional.isPresent()) {
                throw new RuntimeException("El usuario no existe");
            }
            if (!Objects.equals(usuario.getId(), usuarioUpdate.getId())) {
                throw new RuntimeException("El id no coincide");
            }

            try {
                userService.update(usuario.getUser().getId(), usuarioUpdate.getUser());
            }catch (Exception e){
                throw new RuntimeException(e.getMessage());
            }

            System.out.println("usuarioUpdate: " + mapper.writeValueAsString(usuario));

            return usuariosRepository.save(usuario);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Usuarios activarUsuario(Integer idUsuario) {
        try {
            Optional<Usuarios> optional = usuariosRepository.findById(idUsuario);
            if (optional.isPresent()) {
                Usuarios usuario = optional.get();
                User user = usuario.getUser();
                user.setActivo(true);
                usuario.setUser(user);
                usuario.setActivo(true);
                return usuariosRepository.save(usuario);
            } else {
                throw new RuntimeException("El usuario no existe");
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
