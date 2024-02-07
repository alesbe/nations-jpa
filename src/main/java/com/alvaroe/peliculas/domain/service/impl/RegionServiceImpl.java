package com.alvaroe.peliculas.domain.service.impl;

import com.alvaroe.peliculas.domain.entity.Country;
import com.alvaroe.peliculas.domain.entity.Region;
import com.alvaroe.peliculas.domain.repository.CountryRepository;
import com.alvaroe.peliculas.domain.repository.RegionRepository;
import com.alvaroe.peliculas.domain.service.RegionService;
import com.alvaroe.peliculas.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionServiceImpl implements RegionService {
    @Autowired
    RegionRepository repository;

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
}
