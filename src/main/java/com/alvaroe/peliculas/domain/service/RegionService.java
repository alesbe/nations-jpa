package com.alvaroe.peliculas.domain.service;

import com.alvaroe.peliculas.controller.model.region.RegionSaveWeb;
import com.alvaroe.peliculas.domain.entity.Country;
import com.alvaroe.peliculas.domain.entity.Region;

import java.util.List;

public interface RegionService {
    List<Region> getAll(Integer page, Integer pageSize);
    List<Region> getAll();
    Region findById(Integer id);
    public int save(RegionSaveWeb regionSaveWeb);
    void delete(int regionId);
}
