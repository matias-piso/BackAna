package com.java.flexilab.repositories;

import com.java.flexilab.entities.actors.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends BaseRepository<Admin, Integer> {

    public Admin findByEmail(String email);

}
