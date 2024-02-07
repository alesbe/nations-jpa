package com.alvaroe.peliculas.domain.repository;

import com.alvaroe.peliculas.domain.entity.Continent;
import com.alvaroe.peliculas.domain.entity.Region;

import java.util.List;
import java.util.Optional;

public interface ContinentRepository {
    public List<Continent> getAll(Integer page, Integer pageSize);
    public Optional<Continent> findById(Integer id);
    public int save(Continent continent);
}
