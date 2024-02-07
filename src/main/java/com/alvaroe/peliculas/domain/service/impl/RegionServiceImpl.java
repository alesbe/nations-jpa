package com.alvaroe.peliculas.domain.service.impl;

import com.alvaroe.peliculas.controller.model.region.RegionSaveWeb;
import com.alvaroe.peliculas.domain.entity.Continent;
import com.alvaroe.peliculas.domain.entity.Country;
import com.alvaroe.peliculas.domain.entity.Language;
import com.alvaroe.peliculas.domain.entity.Region;
import com.alvaroe.peliculas.domain.repository.ContinentRepository;
import com.alvaroe.peliculas.domain.repository.CountryRepository;
import com.alvaroe.peliculas.domain.repository.RegionRepository;
import com.alvaroe.peliculas.domain.service.RegionService;
import com.alvaroe.peliculas.exception.ResourceNotFoundException;
import com.alvaroe.peliculas.mapper.CountryMapper;
import com.alvaroe.peliculas.mapper.RegionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionServiceImpl implements RegionService {
    @Autowired
    RegionRepository repository;

    @Autowired
    ContinentRepository continentRepository;

    @Override
    public List<Region> getAll(Integer page, Integer pageSize) {
        return this.repository.getAll(page, pageSize);
    }

    @Override
    public List<Region> getAll() {
        return this.repository.getAll(null, null);
    }

    @Override
    public Region findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Region not found with id: " + id));
    }

    @Override
    public int save(RegionSaveWeb regionSaveWeb) {
        Region region = RegionMapper.mapper.toRegion(regionSaveWeb);

        Continent continent = continentRepository.findById(regionSaveWeb.getContinentId())
                .orElseThrow(() -> new ResourceNotFoundException("Region not found with id: " + regionSaveWeb.getContinentId()));

        region.setContinent(continent);

        return repository.save(region);
    }
}
