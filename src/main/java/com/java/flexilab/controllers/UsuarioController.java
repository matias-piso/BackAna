package com.java.flexilab.controllers;

import com.java.flexilab.configSecurity.model.User;
import com.java.flexilab.entities.actors.Usuarios;
import com.java.flexilab.services.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("")
    public ResponseEntity<?> findAll(Pageable pageable, @RequestParam(name = "sort", required = false) String sort) {
        try {
            return ResponseEntity.ok().body(usuarioService.findAll(pageable));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

/*
    @GetMapping("/email/{email}")
    public Optional<User> findByEmail2(@PathVariable(value = "email") String email) {
        System.out.println("Email: " + email);
        return usuarioService.findByEmail2(email);
    }


 */



}