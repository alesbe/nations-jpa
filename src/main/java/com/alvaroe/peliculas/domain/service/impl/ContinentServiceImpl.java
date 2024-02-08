package com.alvaroe.peliculas.domain.service.impl;

import com.alvaroe.peliculas.controller.model.continent.ContinentSaveWeb;
import com.alvaroe.peliculas.domain.entity.Continent;
import com.alvaroe.peliculas.domain.repository.ContinentRepository;
import com.alvaroe.peliculas.domain.service.ContinentService;
import com.alvaroe.peliculas.exception.ResourceNotFoundException;
import com.alvaroe.peliculas.mapper.ContinentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContinentServiceImpl implements ContinentService {
    @Autowired
    ContinentRepository repository;

    @Override
    public List<Continent> getAll(Integer page, Integer pageSize) {
        return this.repository.getAll(page, pageSize);
    }

    @Override
    public List<Continent> getAll() {
        return this.repository.getAll(null, null);
    }

    @Override
    public Continent findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Continent not found with id: " + id));
    }

    @Override
    public int save(ContinentSaveWeb continentSaveWeb) {
        return this.repository.save(ContinentMapper.mapper.toContinent(continentSaveWeb));
    }

    @Override
    public void delete(int continentId) {
        repository.findById(continentId)
                .orElseThrow(() -> new ResourceNotFoundException("Continent not found with id: " + continentId));

        repository.delete(continentId);
    }
}
