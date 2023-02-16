package com.java.flexilab.entities.sistem;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class CategoriaBlog {
    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String nombre;

    public CategoriaBlog(){
        super();
    }

}
