package com.java.flexilab.controllers;

import com.java.flexilab.entities.sistem.Producto;
import com.java.flexilab.services.ProductoServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/producto")
public class ProductoCotroller extends BaseControllerImpl<Producto, ProductoServiceImpl> {

    @GetMapping(path = {"/filtrar","/filtrar/"})
    public ResponseEntity<?> buscar(
            @RequestParam(required = false) String categoria,
            @PageableDefault(size = 20) Pageable pageable) {
        try {
            if (categoria != null) {
                System.out.println("categoria: " + categoria);
                Page<Producto> productos = service.findByCategoria(categoria, pageable);
                return ResponseEntity.status(HttpStatus.OK).body(productos);
            } else {
                System.out.println("SIN categoria: " + categoria);
                Page<Producto> productos = service.findAll(pageable);
                return ResponseEntity.status(HttpStatus.OK).body(productos);
            }

        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo encontrar el enum");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ocurrió un error al buscar el producto");
        }
    }
}