package com.java.flexilab.controllers;


import com.java.flexilab.entities.sistem.Categoria;
import com.java.flexilab.entities.sistem.CompraRealizada;
import com.java.flexilab.services.CategoriaServiceImpl;
import com.java.flexilab.services.CompraRealizadaServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/v1/comprasrealizadas")
public class CompraRealizadaController extends BaseControllerImpl<CompraRealizada, CompraRealizadaServiceImpl> {

}