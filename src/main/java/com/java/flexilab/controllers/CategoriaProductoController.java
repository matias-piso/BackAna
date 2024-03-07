package com.java.flexilab.controllers;

import com.java.flexilab.entities.sistem.CategoriaProducto;
import com.java.flexilab.entities.sistem.Producto;
import com.java.flexilab.services.CategoriaProductoServiceImpl;
import com.java.flexilab.services.ProductoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/categoriasProducto")
public class CategoriaProductoController extends BaseControllerImpl<CategoriaProducto, CategoriaProductoServiceImpl> {

    @GetMapping(path = {"","/"})
    public ResponseEntity<?> getRecordBy() {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(service.findAllWithOutPage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron registros");
        }
    }

}