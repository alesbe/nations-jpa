package com.alvaroe.peliculas.domain.repository;

import com.alvaroe.peliculas.domain.entity.Country;
import com.alvaroe.peliculas.domain.entity.Region;

import java.util.List;
import java.util.Optional;

public interface RegionRepository {
    public List<Region> getAll(Integer page, Integer pageSize);
    public Optional<Region> findById(Integer id);
    public int save(Region region);
    public void delete(int regionId);
}
