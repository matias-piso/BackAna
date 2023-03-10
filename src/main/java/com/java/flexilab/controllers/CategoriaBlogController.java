package com.java.flexilab.controllers;


import com.java.flexilab.entities.sistem.CategoriaBlog;
import com.java.flexilab.services.CategoriaBlogServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/v1/categoriasblog")
public class CategoriaBlogController extends BaseControllerImpl<CategoriaBlog, CategoriaBlogServiceImpl> {

}