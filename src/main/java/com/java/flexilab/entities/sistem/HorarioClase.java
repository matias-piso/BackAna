package com.java.flexilab.entities.sistem;

import com.fasterxml.jackson.annotation.JsonFormat;
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
import java.util.Date;

import java.sql.Time;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HorarioClase extends Base {

    @NotNull
    private EnumDia dia;

    @NotNull
    private Time hora;

    public HorarioClase(String dia, Time hora) {
        this.dia = EnumDia.valueOf(dia);
        this.hora = hora;
    }
}
