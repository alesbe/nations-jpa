package com.alvaroe.peliculas.domain.service.impl;

import com.alvaroe.peliculas.domain.entity.Country;
import com.alvaroe.peliculas.domain.repository.CountryRepository;
import com.alvaroe.peliculas.domain.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    CountryRepository repository;

    @Override
    public List<Country> getAll(Integer page, Integer pageSize) {
        return this.repository.getAll(page, pageSize);
    }
}
