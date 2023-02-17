package com.java.flexilab.controllers;

import com.java.flexilab.entities.actors.Admin;
import com.java.flexilab.services.AdminServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/v1/admins")
public class AdminController extends BaseControllerImpl<Admin, AdminServiceImpl> {

}