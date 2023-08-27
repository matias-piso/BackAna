package com.java.flexilab.configSecurity.model;

import com.java.flexilab.entities.Base;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase que representa los roles que puede tener un usuario.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class Rol extends Base {
    private String nombre;
    private String descripcion;
}