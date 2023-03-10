package com.java.flexilab.controllers;


import com.java.flexilab.entities.sistem.Categoria;
import com.java.flexilab.services.CategoriaServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/v1/categorias")
public class CategoriaController extends BaseControllerImpl<Categoria, CategoriaServiceImpl> {

}