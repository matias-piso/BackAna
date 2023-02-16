package com.java.flexilab.DTO;

import com.java.flexilab.entities.actors.Admin;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "AdminDTO",types = Admin.class)
public interface AdminDTO {

    String getUsuario();


}
