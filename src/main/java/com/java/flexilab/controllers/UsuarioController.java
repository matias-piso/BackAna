package com.java.flexilab.controllers;

import com.java.flexilab.configSecurity.model.User;
import com.java.flexilab.entities.actors.Usuarios;
import com.java.flexilab.services.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/v1/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioServiceImpl usuarioService;


    @GetMapping("/email/{email}")
    public Usuarios findByEmail(@PathVariable(value = "email") String email) {
        System.out.println("Email: " + email);
        return usuarioService.findByEmail(email);
    }

/*
    @GetMapping("/email/{email}")
    public Optional<User> findByEmail2(@PathVariable(value = "email") String email) {
        System.out.println("Email: " + email);
        return usuarioService.findByEmail2(email);
    }


 */



}