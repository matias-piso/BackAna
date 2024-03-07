package com.java.flexilab.services;

import com.java.flexilab.entities.actors.Admin;
import com.java.flexilab.entities.actors.Usuarios;
import com.java.flexilab.interfaces.AdminService;
import com.java.flexilab.repositories.AdminRepo;
import com.java.flexilab.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdminServiceImpl extends BaseServiceImpl<Admin, Integer> implements AdminService {

    @Autowired
    private AdminRepo adminRepository;

    public AdminServiceImpl(BaseRepository<Admin, Integer> baseRepository) {
        super(baseRepository);
    }

    public Admin findByEmail(String email) {
        Admin admin = adminRepository.findByEmail(email);
        System.out.println("Admin: " + admin);
        System.out.println("Email: " + email);
        return admin;
    }


}
