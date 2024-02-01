package com.alvaroe.peliculas.domain.repository;

import com.alvaroe.peliculas.domain.entity.Country;
import com.alvaroe.peliculas.persistance.model.CountryEntity;

import java.util.List;
import java.util.Optional;

public interface CountryRepository {
    public List<Country> getAll(Integer page, Integer pageSize);
    public Optional<Country> findById(Integer id);
    public int save(Country country);
    public void delete(int countryId);
}
