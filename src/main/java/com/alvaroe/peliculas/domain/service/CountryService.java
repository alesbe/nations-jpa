package com.alvaroe.peliculas.domain.service;

import com.alvaroe.peliculas.controller.model.country.CountrySaveWeb;
import com.alvaroe.peliculas.domain.entity.Country;
import org.springframework.stereotype.Component;

import java.util.List;

public interface CountryService {
    List<Country> getAll(Integer page, Integer pageSize);
    List<Country> getAll();
    Country findById(Integer id);
    int save(CountrySaveWeb countrySaveWeb);
    void delete(int countryId);
}
