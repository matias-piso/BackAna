package com.java.flexilab.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.flexilab.configSecurity.model.UserRegister;
import com.java.flexilab.configSecurity.service.UserRegisterService;
import com.java.flexilab.entities.actors.Profesor;
import com.java.flexilab.entities.sistem.Producto;
import com.java.flexilab.services.ProductoServiceImpl;
import com.java.flexilab.services.ProfesorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/profesores")
public class ProfesorCotroller extends BaseControllerImpl<Profesor, ProfesorServiceImpl> {

    @Autowired
    private ProfesorServiceImpl profesorService;


    @PostMapping("/register")
    public ResponseEntity<?> registerProfe (@RequestBody UserRegister userRegistration) {
        try {
            if (profesorService.registerProfe(userRegistration, "ROLE_PROFESOR"))
                return new ResponseEntity<>(HttpStatus.CREATED);
        } catch(Exception e) {
            return new ResponseEntity<>(e.getMessage(), null, HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProfe (@PathVariable Integer id) {
        try {
            profesorService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(e.getMessage(), null, HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/activar/{idProf}")
    public ResponseEntity<?> activarProfesor(@PathVariable(value = "idProf") Integer idProf) {
        try {
            return ResponseEntity.ok().body(profesorService.activarUsuario(idProf));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}