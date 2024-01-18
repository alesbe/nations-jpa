package com.alvaroe.peliculas.domain.repository;

import com.alvaroe.peliculas.domain.entity.Country;

import java.util.List;

public interface CountryRepository {
    public List<Country> getAll(Integer page, Integer pageSize);
}
