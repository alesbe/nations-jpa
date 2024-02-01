package com.alvaroe.peliculas.domain.service.impl;

import com.alvaroe.peliculas.domain.entity.Language;
import com.alvaroe.peliculas.domain.entity.Region;
import com.alvaroe.peliculas.domain.repository.LanguageRepository;
import com.alvaroe.peliculas.domain.service.LanguageService;
import com.alvaroe.peliculas.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageServiceImpl implements LanguageService {
    @Autowired
    LanguageRepository repository;

    @Override
    public List<Language> getAll(Integer page, Integer pageSize) {
        return repository.getAll(page, pageSize);
    }

    @Override
    public List<Language> getAll() {
        return repository.getAll(null, null);
    }

    @Override
    public Language findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Language not found with id: " + id));
    }
}
