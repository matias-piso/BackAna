package com.java.flexilab.entities.sistem;

import com.java.flexilab.entities.Base;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CategoriaProducto extends Base {

    @NotBlank(message = "El nombre no puede estar vacio")
    @Column
    private String nombre;

}
