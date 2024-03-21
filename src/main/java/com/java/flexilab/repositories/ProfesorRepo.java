package com.java.flexilab.repositories;

import com.java.flexilab.entities.actors.Profesor;
import com.java.flexilab.entities.sistem.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfesorRepo extends BaseRepository<Profesor, Integer>{


}
