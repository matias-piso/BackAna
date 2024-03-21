package com.java.flexilab.controllers;

import com.java.flexilab.entities.sistem.EnumEstadoCompra;
import com.java.flexilab.entities.sistem.EnumMetodoPago;
import com.java.flexilab.entities.sistem.HorarioClase;
import com.java.flexilab.services.HorarioClaseServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/v1/horarioClase")
public class HorarioClaseController extends BaseControllerImpl<HorarioClase, HorarioClaseServiceImpl>{
}
