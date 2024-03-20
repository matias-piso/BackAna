package com.java.flexilab.DTO;

import com.java.flexilab.entities.sistem.Clases;
import io.swagger.models.auth.In;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
public class ClaseCantidadDTO {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter
    @Setter
    @ManyToOne
    private Clases clase;

    @Getter
    @Setter
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
