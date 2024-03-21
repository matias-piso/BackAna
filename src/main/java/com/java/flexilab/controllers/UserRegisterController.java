package com.java.flexilab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.flexilab.configSecurity.model.UserRegister;
import com.java.flexilab.configSecurity.service.UserRegisterService;

/**
 * Controlador para las operaciones relacionadas con el registro de nuevos usuarios.
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/usuarios/signup")
public class UserRegisterController {

    @Autowired
    private UserRegisterService usuarioRegisterService;

    /**
     * Registra un nuevo usuario.
     *
     * @param userRegistration Objeto UsuarioRegister que contiene los datos de registro del usuario.
     * @return ResponseEntity con estado HTTP 201 (Created) si el usuario se registra correctamente.
     *         Si hay una violación de integridad de datos al registrar el usuario, se devuelve un ResponseEntity con estado HTTP 409 (Conflict).
     *         En caso de error, se devuelve un ResponseEntity con el mensaje de error y el estado HTTP 409 (Conflict).
     */
    @PostMapping
    public ResponseEntity<?> registerUser(@RequestBody UserRegister userRegistration) {

        try {
            if (usuarioRegisterService.registerUser(userRegistration, "ROLE_USER"))
                return new ResponseEntity<>(HttpStatus.CREATED);


        } catch(Exception e) {
            return new ResponseEntity<>(e.getMessage(), null, HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}