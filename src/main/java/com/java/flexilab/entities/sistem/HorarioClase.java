package com.java.flexilab.entities.sistem;

import com.java.flexilab.entities.Base;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Entity
@Getter
@Setter
public class HorarioClase extends Base {

    @NotNull
    private LocalTime hora;

}
