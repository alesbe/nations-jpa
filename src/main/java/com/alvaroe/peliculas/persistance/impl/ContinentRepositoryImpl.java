package com.alvaroe.peliculas.persistance.impl;

import com.alvaroe.peliculas.domain.entity.Continent;
import com.alvaroe.peliculas.domain.entity.Region;
import com.alvaroe.peliculas.domain.repository.ContinentRepository;
import com.alvaroe.peliculas.mapper.ContinentMapper;
import com.alvaroe.peliculas.mapper.RegionMapper;
import com.alvaroe.peliculas.persistance.dao.ContinentDAO;
import com.alvaroe.peliculas.persistance.dao.RegionDAO;
import com.alvaroe.peliculas.persistance.model.ContinentEntity;
import com.alvaroe.peliculas.persistance.model.RegionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ContinentRepositoryImpl implements ContinentRepository {
    @Autowired
    ContinentDAO continentDAO;

    @Override
    public List<Continent> getAll(Integer page, Integer pageSize) {
        List<ContinentEntity> continentEntities;

        if(page != null && page > 0) {
            Pageable pageable = PageRequest.of(page - 1, pageSize);
            continentEntities = continentDAO.findAll(pageable).stream().toList();
        } else {
            continentEntities = continentDAO.findAll();
        }

        return continentEntities.stream().map(ContinentMapper.mapper::toContinent).toList();
    }

    @Override
    public Optional<Continent> findById(Integer id) {
        Optional<ContinentEntity> continentEntity = continentDAO.findById(id);

        if(continentEntity.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(ContinentMapper.mapper.toContinent(continentEntity.get()));
    }

    @Override
    public int save(Continent continent) {
        return continentDAO.save(ContinentMapper.mapper.toContinentEntity(continent)).getId();
    }

    @Override
    public void delete(int countryId) {
        continentDAO.deleteById(countryId);
    }
}
