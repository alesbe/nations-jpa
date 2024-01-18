package com.alvaroe.peliculas.domain.service;

import com.alvaroe.peliculas.domain.entity.Country;
import org.springframework.stereotype.Component;

import java.util.List;

public interface CountryService {
    List<Country> getAll(Integer page, Integer pageSize);
}
