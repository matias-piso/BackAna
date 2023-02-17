package com.java.flexilab.repositories;

import com.java.flexilab.entities.actors.Admin;
import com.java.flexilab.entities.sistem.ArticulosBlog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticulosBlogRepo extends BaseRepository<ArticulosBlog, Integer> {
}
