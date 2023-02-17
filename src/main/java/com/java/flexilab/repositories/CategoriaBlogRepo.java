package com.java.flexilab.repositories;

import com.java.flexilab.entities.sistem.CategoriaBlog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaBlogRepo extends JpaRepository<CategoriaBlog,Integer> {
}
