package com.java.flexilab.DTO;

import com.java.flexilab.entities.sistem.Clases;
import com.java.flexilab.entities.sistem.HorarioClase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClaseDTOpost {
    private Integer claseId;
    private Integer cantidadDisponible;
    private Integer diaHorarioClaseId;
}
