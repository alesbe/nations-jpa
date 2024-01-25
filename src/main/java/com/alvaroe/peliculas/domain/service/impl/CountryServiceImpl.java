package com.alvaroe.peliculas.domain.service.impl;

import com.alvaroe.peliculas.domain.entity.Country;
import com.alvaroe.peliculas.domain.repository.CountryRepository;
import com.alvaroe.peliculas.domain.service.CountryService;
import com.alvaroe.peliculas.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    CountryRepository repository;

    @Override
    public List<Country> getAll(Integer page, Integer pageSize) {
        return this.repository.getAll(page, pageSize);
    }

    @Override
    public List<Country> getAll() {
        return this.repository.getAll(null, null);
    }

    @Override
    public Country findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Country not found with id: " + id));
    }
}
