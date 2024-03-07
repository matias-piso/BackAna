package com.java.flexilab.controllers;


import com.java.flexilab.entities.sistem.Categoria;
import com.java.flexilab.services.CategoriaServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/v1/categorias")
public class CategoriaController extends BaseControllerImpl<Categoria, CategoriaServiceImpl> {

    @GetMapping(path = {"","/"})
    public ResponseEntity<?> getRecordBy() {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(service.findAllWithOutPage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron registros");
        }
    }

}