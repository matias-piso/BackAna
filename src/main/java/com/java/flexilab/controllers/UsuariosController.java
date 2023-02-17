package com.java.flexilab.controllers;


import com.java.flexilab.entities.actors.Usuarios;
import com.java.flexilab.repositories.UsuariosRepo;
import com.java.flexilab.services.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/v1/usuarios")
public class UsuariosController extends BaseControllerImpl<Usuarios, UsuarioServiceImpl> {

}