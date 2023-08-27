package com.java.flexilab.configSecurity.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

import com.java.flexilab.entities.Base;

/**
 * Clase que representa a un usuario en el sistema.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuario")
public class User extends Base {
    private String email;
    private String password;
    private String nombre;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
        name = "usuario_rol",
        joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "rol_id", referencedColumnName = "id")
    )
    private Set<Rol> roles = new HashSet<>();
}