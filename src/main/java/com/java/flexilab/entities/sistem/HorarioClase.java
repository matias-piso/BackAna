package com.java.flexilab.entities.sistem;

import com.java.flexilab.entities.Base;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HorarioClase extends Base {

    @NotNull
    private EnumDia dia;

    @NotNull
    private LocalTime hora;

    public HorarioClase(String dia, LocalTime hora) {
        this.dia = EnumDia.valueOf(dia);
        this.hora = hora;
    }

}
