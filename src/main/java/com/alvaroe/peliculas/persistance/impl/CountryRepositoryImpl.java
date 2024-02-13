package com.alvaroe.peliculas.persistance.impl;

import com.alvaroe.peliculas.domain.entity.Country;
import com.alvaroe.peliculas.domain.repository.CountryRepository;
import com.alvaroe.peliculas.mapper.CountryMapper;
import com.alvaroe.peliculas.persistance.dao.CountryDAO;
import com.alvaroe.peliculas.persistance.model.CountryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CountryRepositoryImpl implements CountryRepository {

    @Autowired
    CountryDAO countryDAO;

    @Override
    public List<Country> getAll(Integer page, Integer pageSize) {
        List<CountryEntity> countryEntities;

        if(page != null && page > 0) {
            Pageable pageable = PageRequest.of(page - 1, pageSize);
            countryEntities = countryDAO.findAll(pageable).stream().toList();
        } else {
            countryEntities = countryDAO.findAll();
        }

        return countryEntities.stream().map(CountryMapper.mapper::toCountry).toList();
    }

    @Override
    public Optional<Country> findById(Integer id) {
        Optional<CountryEntity> countryEntity = countryDAO.findById(id);

        if(countryEntity.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(CountryMapper.mapper.toCountry(countryEntity.get()));
    }

    @Override
    public int save(Country country) {
        return countryDAO.save(CountryMapper.mapper.toCountryEntity(country)).getId();
    }

    @Override
    public void delete(int countryId) {
        countryDAO.deleteById(countryId);
    }

    @Override
    public List<Country> findCountriesByRegionName(String regionName) {
        List<CountryEntity> countryEntities = countryDAO.findCountriesByRegionName(regionName);

        return countryEntities.stream()
                .map(CountryMapper.mapper::toCountry)
                .toList();
    }
}
