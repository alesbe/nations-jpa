package com.alvaroe.peliculas.domain.service;

import com.alvaroe.peliculas.domain.entity.Continent;
import com.alvaroe.peliculas.domain.entity.Region;

import java.util.List;

public interface ContinentService {
    List<Continent> getAll(Integer page, Integer pageSize);
    List<Continent> getAll();
    Continent findById(Integer id);
}