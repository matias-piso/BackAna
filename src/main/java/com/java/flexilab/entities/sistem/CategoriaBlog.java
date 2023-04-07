package com.java.flexilab.entities.sistem;

import jakarta.persistence.*;

import com.java.flexilab.entities.Base;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class CategoriaBlog extends Base {

    @NotBlank(message = "El nombre no puede estar vacio")
    @Column
    private String nombre;

    public CategoriaBlog(){
        super();
    }

}
