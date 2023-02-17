package com.java.flexilab.entities.sistem;

import jakarta.persistence.*;

import com.java.flexilab.entities.Base;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class CategoriaBlog extends Base {

    @Column
    private String nombre;

    public CategoriaBlog(){
        super();
    }

}
