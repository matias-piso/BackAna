package com.java.flexilab.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.flexilab.DTO.CompraRealizadaDTO;
import com.java.flexilab.DTO.CompraRealizadaDTOupdate;
import com.java.flexilab.configSecurity.config.TokenUtils;
import com.java.flexilab.entities.actors.Usuarios;
import com.java.flexilab.entities.sistem.CompraRealizada;
import com.java.flexilab.services.CompraRealizadaServiceImpl;
import io.swagger.models.Response;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/v1/")
public class CompraRealizadaController {

    @Autowired
    private CompraRealizadaServiceImpl compraRealizadaService;

    @PostMapping("/cliente/{idUsuario}/compraRealizadas")
    public ResponseEntity<?> saveCompraRealizada(@Valid @RequestBody CompraRealizadaDTO compraRealizada,
                                                 @PathVariable Integer idUsuario, HttpServletRequest request) throws Exception {
        try {
            ObjectMapper mapper = new ObjectMapper();
            System.out.println("Compra realizada: " + mapper.writeValueAsString(compraRealizada));
            return ResponseEntity.status(201).body(compraRealizadaService.save(compraRealizada, idUsuario, request));
        }catch (ValidationException e){
            return ResponseEntity.status(400).body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PutMapping("/compraRealizada/{idCompraRealizada}")
    public ResponseEntity<?> updateCompraRealizada(@Valid @RequestBody CompraRealizadaDTOupdate compraRealizadaDTOupdate,
                                                   @PathVariable Integer idCompraRealizada, HttpServletRequest request) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            System.out.println("Compra realizada: " + mapper.writeValueAsString(compraRealizadaDTOupdate));
            return ResponseEntity.status(201).body(compraRealizadaService.updateCompraRealizada(compraRealizadaDTOupdate, idCompraRealizada, request));
        } catch (ValidationException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/cliente/{idUsuario}/compraRealizadas")
    public ResponseEntity<?> getComprasRealizadas(@PathVariable Integer idUsuario, HttpServletRequest request) {
        try {
            System.out.println("ID Usuario: " + idUsuario);
            // Llamar al servicio para obtener las compras realizadas
            return ResponseEntity.status(HttpStatus.OK).body(compraRealizadaService.getComprasRealizadas(idUsuario, request));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }


}