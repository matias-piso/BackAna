package com.java.flexilab.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}