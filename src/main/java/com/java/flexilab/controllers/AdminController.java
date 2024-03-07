package com.java.flexilab.controllers;

import com.java.flexilab.configSecurity.model.User;
import com.java.flexilab.entities.actors.Admin;
import com.java.flexilab.services.AdminServiceImpl;
import com.java.flexilab.services.UsuarioServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/v1/admins")
public class AdminController extends BaseControllerImpl<Admin, AdminServiceImpl> {
    @Autowired
    private AdminServiceImpl adminService;

    @GetMapping("/email/{email}")
    public User findByEmail(@PathVariable(value = "email") String email) {
        return adminService.findByEmail(email);
    }

}