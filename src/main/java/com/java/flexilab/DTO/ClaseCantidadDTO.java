package com.java.flexilab.DTO;

import com.java.flexilab.entities.sistem.Clases;
import com.java.flexilab.entities.sistem.HorarioClase;
import io.swagger.models.auth.In;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Entity
@AllArgsConstructor
public class ClaseCantidadDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Setter
    @ManyToOne
    private Clases clase;

    @Setter
    private Integer cantidadDisponible;

    @Setter
    @ManyToOne
    private HorarioClase diaHorarioClase;

    public ClaseCantidadDTO(){
        super();
        this.cantidadDisponible = 4;
    }

    public ClaseCantidadDTO(Clases clase){
        super();
        System.out.println("ClaseCantidadDTO -------------------------------");
        this.clase = clase;
        this.cantidadDisponible = 4;
    }

}
