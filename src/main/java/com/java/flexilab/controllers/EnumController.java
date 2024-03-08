package com.java.flexilab.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.flexilab.entities.sistem.EnumMetodoPago;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/v1/enums")
public class EnumController {

    /*
    @GetMapping("")
    public String getEnums() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(EnumMetodoPago.values());
        return json;
    }
     */

    @GetMapping("")
    public List<EnumMetodoPago> getEnums() {
        return List.of(EnumMetodoPago.values());
    }


}
