package com.alvaroe.peliculas.persistance.impl;

import com.alvaroe.peliculas.domain.entity.Region;
import com.alvaroe.peliculas.domain.repository.RegionRepository;
import com.alvaroe.peliculas.mapper.CountryMapper;
import com.alvaroe.peliculas.mapper.RegionMapper;
import com.alvaroe.peliculas.persistance.dao.CountryDAO;
import com.alvaroe.peliculas.persistance.dao.RegionDAO;
import com.alvaroe.peliculas.persistance.model.CountryEntity;
import com.alvaroe.peliculas.persistance.model.RegionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RegionRepositoryImpl implements RegionRepository {
    @Autowired
    RegionDAO regionDAO;

    @Override
    public List<Region> getAll(Integer page, Integer pageSize) {
        List<RegionEntity> regionEntities;

        if(page != null && page > 0) {
            Pageable pageable = PageRequest.of(page - 1, pageSize);
            regionEntities = regionDAO.findAll(pageable).stream().toList();
        } else {
            regionEntities = regionDAO.findAll();
        }

        return regionEntities.stream().map(RegionMapper.mapper::toRegion).toList();
    }

    @Override
    public Optional<Region> findById(Integer id) {
        Optional<RegionEntity> regionEntity = regionDAO.findById(id);

        if(regionEntity.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(RegionMapper.mapper.toRegion(regionEntity.get()));
    }

    @Override
    public int save(Region region) {
        return regionDAO.save(RegionMapper.mapper.toRegionEntity(region)).getId();
    }

    @Override
    public void delete(int regionId) {
        regionDAO.deleteById(regionId);
    }
}
