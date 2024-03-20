package com.java.flexilab.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.java.flexilab.entities.sistem.Clases;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClaseDTOupdate {
        @JsonProperty("id")
        private Integer id;

        @JsonProperty("cantidadDisponible")
        private Integer cantidadDisponible;
}
