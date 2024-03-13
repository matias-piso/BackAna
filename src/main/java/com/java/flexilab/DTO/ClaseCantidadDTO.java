package com.java.flexilab.DTO;

import com.java.flexilab.entities.sistem.Clases;
import io.swagger.models.auth.In;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ClaseCantidadDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Clases clase;

    private Integer cantidadDisponible;

    public ClaseCantidadDTO(){
        super();
        this.cantidadDisponible = 4;
    }

    public ClaseCantidadDTO(Clases clase){
        super();
        this.clase = clase;
        this.cantidadDisponible = 4;
    }

}
