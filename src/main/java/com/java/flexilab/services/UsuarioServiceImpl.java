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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UsuarioServiceImpl extends BaseServiceImpl<Usuarios, Integer> implements UsuarioService {

    @Autowired
    private UsuariosRepo usuariosRepository;

    public UsuarioServiceImpl(BaseRepository<Usuarios, Integer> baseRepository) {
        super(baseRepository);
    }

    public Usuarios findByEmail(String email) {
        Usuarios usu = usuariosRepository.findByUserEmail(email);
        System.out.println("User: " + usu);
        System.out.println("Email: " + email);
        return usu;
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

}
