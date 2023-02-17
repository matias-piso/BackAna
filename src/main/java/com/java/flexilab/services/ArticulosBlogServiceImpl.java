package com.java.flexilab.services;

import com.java.flexilab.entities.sistem.ArticulosBlog;
import com.java.flexilab.interfaces.ArticulosBlogService;
import com.java.flexilab.repositories.BaseRepository;
import org.springframework.stereotype.Service;

@Service
public class ArticulosBlogServiceImpl extends BaseServiceImpl<ArticulosBlog, Integer> implements ArticulosBlogService {
    public ArticulosBlogServiceImpl(BaseRepository<ArticulosBlog, Integer> baseRepository) {
        super(baseRepository);
    }
}
