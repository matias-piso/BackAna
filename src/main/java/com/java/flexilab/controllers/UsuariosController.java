package com.java.flexilab.controllers;


import com.java.flexilab.DTO.UsuarioDTOsetter;
import com.java.flexilab.entities.actors.Usuarios;
import com.java.flexilab.services.UsuarioServiceImpl;
import jakarta.persistence.EntityManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/v1/usuarios")
public class UsuariosController extends BaseControllerImpl<Usuarios, UsuarioServiceImpl> {

    private final EntityManager em;

    public UsuariosController(EntityManager em) {
        this.em = em;
    }

    @PostMapping("/login")
    public @ResponseBody ResponseEntity<?> getLogIn(@RequestBody UsuarioDTOsetter usuarioDTOsetter) {

        List<Usuarios> resultCli = em.createQuery("SELECT c FROM Usuarios c WHERE c.email = :email AND c.password = :password", Usuarios.class)
                .setParameter("email", usuarioDTOsetter.getEmail())
                .setParameter("password", usuarioDTOsetter.getPassword())
                .getResultList();
        if (resultCli.size() == 0){
            return new ResponseEntity<>("Usuario o contraseña invalidos", HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(resultCli.get(0).getId(), HttpStatus.OK);
        }

    }


}