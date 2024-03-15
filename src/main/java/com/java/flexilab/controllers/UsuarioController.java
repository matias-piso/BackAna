package com.java.flexilab.controllers;

import com.java.flexilab.DTO.UsuarioDTOupdate;
import com.java.flexilab.configSecurity.model.User;
import com.java.flexilab.entities.actors.Usuarios;
import com.java.flexilab.services.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/page")
    public ResponseEntity<?> findAll (Pageable pageable,
                                     @RequestParam(name = "activo", required = false, defaultValue = "true") boolean activo) {
        try {
            return ResponseEntity.ok().body(usuarioService.findAll(pageable, activo));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable(value = "id") Integer id) {
        try {
            usuarioService.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateById(@PathVariable(value = "id") Integer id, @RequestBody UsuarioDTOupdate usuario) {
        try {
            return ResponseEntity.ok().body(usuarioService.updateById(id, usuario));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/activar/{idUsuario}")
    public ResponseEntity<?> activarUsuario(@PathVariable(value = "idUsuario") Integer idUsuario) {
        try {
            return ResponseEntity.ok().body(usuarioService.activarUsuario(idUsuario));
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