package com.java.flexilab.entities.actors;

import com.java.flexilab.configSecurity.model.Rol;
import com.java.flexilab.configSecurity.model.User;
import com.java.flexilab.entities.Base;
import com.java.flexilab.entities.sistem.Aula;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Profesor extends Base {

    @OneToOne(cascade = CascadeType.ALL)
    private User user;
}
