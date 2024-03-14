package com.java.flexilab.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.flexilab.configSecurity.model.User;
import com.java.flexilab.configSecurity.repository.UserRepository;
import com.java.flexilab.entities.actors.Usuarios;
import com.java.flexilab.entities.sistem.CompraRealizada;
import com.java.flexilab.interfaces.UsuarioService;
import com.java.flexilab.repositories.BaseRepository;
import com.java.flexilab.repositories.UsuariosRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl {

    @Autowired
    private UsuariosRepo usuariosRepository;

    public Usuarios findByEmail(String email) {
        Usuarios usu = usuariosRepository.findByUserEmail(email);
        System.out.println("User: " + usu);
        System.out.println("Email: " + email);
        return usu;
    }

    public Page<Usuarios> findAll(Pageable pageable){
        try {
            return usuariosRepository.findAll(pageable);
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

}
