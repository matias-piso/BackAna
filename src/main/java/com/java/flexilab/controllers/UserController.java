package com.java.flexilab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.java.flexilab.configSecurity.model.User;
import com.java.flexilab.configSecurity.service.UserServiceImpl;
import com.java.flexilab.services.UsuarioServiceImpl;

/**
 * Controlador para las operaciones relacionadas con los usuarios.
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/usuarios")
public class UserController extends BaseControllerImpl<User, UserServiceImpl> {

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @GetMapping("/email/{email}")
    public User findByEmail(@PathVariable(value = "email") String email) {
        return usuarioService.findByEmail(email);
    }

}