package com.java.flexilab.controllers;

import com.java.flexilab.entities.Base;
import com.java.flexilab.interfaces.BaseController;
import com.java.flexilab.services.BaseServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/* MEJORAR CADA OVERRIDE CREO Q EN RESPONSE ENTITY*/
public abstract class BaseControllerImpl < E extends Base, S extends BaseServiceImpl<E,Integer>> implements BaseController<E,Integer> {
    @Autowired
    protected S service;

    @Override
    @GetMapping(path = {"/page"})
    public ResponseEntity<?> getRecordBy(Pageable pageable, @RequestParam(name = "sort", required = false) String sort) {
        try{
            if (sort != null) {
                String[] sortArr = sort.split(",");
                if (sortArr.length == 2) {
                    Sort.Direction direction = sortArr[1].equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
                    pageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), direction, sortArr[0]);
                }else{
                    pageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by(sort));
                }
            }
            return ResponseEntity.status(HttpStatus.OK).body(service.findAll(pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron registros");
        }
    }

    @Override
    @GetMapping(path = {"/page/activos"})
    public ResponseEntity<?> getRecordByActives(Pageable pageable, @RequestParam(name = "sort", required = false) String sort) {
        try{
            if (sort != null) {
                pageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by(sort));
            }
            return ResponseEntity.status(HttpStatus.OK).body(service.findAllByActivoTrue(pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron registros");
        }
    }

    @Override
    @GetMapping(path = {"/page/inactivos"})
    public ResponseEntity<?> getRecordByInactives(Pageable pageable, @RequestParam(name = "sort", required = false) String sort) {
        try{
            if (sort != null) {
                pageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by(sort));
            }
            return ResponseEntity.status(HttpStatus.OK).body(service.findAllByActivoFalse(pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron registros");
        }
    }

    @Override
    @GetMapping(path = {"/{id}","/{id}/"})
    public ResponseEntity<?> getRecordById(@PathVariable Integer id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron registros");
        }
    }

    @Override
    @PostMapping(path = {"","/"})
    public ResponseEntity<?> saveRecord(@Valid @RequestBody E entity, BindingResult result) {
        System.out.println("Entity: " + entity);
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result.getFieldError().getDefaultMessage());
        } else {
            try {
                return ResponseEntity.status(HttpStatus.OK).body(service.save(entity));
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron registros");
            }
        }
    }

    @Override
    @PutMapping(path = {"/{id}","/{id}/"})
    public ResponseEntity<?> updateRecord(@PathVariable Integer id,@Valid @RequestBody E entity, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result.getFieldError().getDefaultMessage());
        } else {
            try {
                return ResponseEntity.status(HttpStatus.OK).body(service.update(id,entity));
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron registros");
            }
        }
    }

    @Override
    @DeleteMapping(path = {"/{id}","/{id}/"})
    public ResponseEntity<?> deleteRecord(@PathVariable Integer id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.delete(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron registros");
        }
    }

}