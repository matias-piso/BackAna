package com.java.flexilab.controllers;


import com.java.flexilab.entities.actors.Usuarios;
import com.java.flexilab.repositories.UsuariosRepo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
@AllArgsConstructor
public class UsuariosController {
    private UsuariosRepo usuariosRepo;

}