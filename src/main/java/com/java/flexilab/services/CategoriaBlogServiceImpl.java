package com.java.flexilab.services;

import com.java.flexilab.entities.sistem.CategoriaBlog;
import com.java.flexilab.interfaces.CategoriaBlogService;
import com.java.flexilab.repositories.BaseRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoriaBlogServiceImpl extends BaseServiceImpl<CategoriaBlog, Integer> implements CategoriaBlogService {
    public CategoriaBlogServiceImpl(BaseRepository<CategoriaBlog, Integer> baseRepository) {
        super(baseRepository);
    }
}
