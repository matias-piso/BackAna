package com.java.flexilab.entities.actors;

import com.java.flexilab.configSecurity.model.Rol;
import com.java.flexilab.configSecurity.model.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import com.java.flexilab.entities.Base;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "admin")
public class Admin extends User {
    // Constructor existente
    public Admin() {
        super(); // Llamar al constructor de la clase base
    }

    // Nuevo constructor con parámetros adicionales
    public Admin(String email, String password, String username, Set<Rol> roles) {
        super(email, password, username, roles);
    }
}