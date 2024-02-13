package com.alvaroe.peliculas.domain.service.impl;

import com.alvaroe.peliculas.controller.model.country.CountrySaveWeb;
import com.alvaroe.peliculas.domain.entity.Country;
import com.alvaroe.peliculas.domain.entity.Language;
import com.alvaroe.peliculas.domain.entity.Region;
import com.alvaroe.peliculas.domain.repository.CountryRepository;
import com.alvaroe.peliculas.domain.repository.LanguageRepository;
import com.alvaroe.peliculas.domain.repository.RegionRepository;
import com.alvaroe.peliculas.domain.service.CountryService;
import com.alvaroe.peliculas.exception.ResourceNotFoundException;
import com.alvaroe.peliculas.mapper.CountryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static com.alvaroe.peliculas.common.validation.Validation.validate;

@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    CountryRepository repository;
    @Autowired
    RegionRepository regionRepository;
    @Autowired
    LanguageRepository languageRepository;

    @Override
    public List<Country> getAll(Integer page, Integer pageSize) {
        return this.repository.getAll(page, pageSize);
    }

    @Override
    public List<Country> getAll() {
        return this.repository.getAll(null, null);
    }

    @Override
    public Country findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Country not found with id: " + id));
    }

    @Override
    public int save(CountrySaveWeb countrySaveWeb) {
        Country country = CountryMapper.mapper.toCountry(countrySaveWeb);

        Region region = regionRepository.findById(countrySaveWeb.getRegionId())
                .orElseThrow(() -> new ResourceNotFoundException("Region not found with id: " + countrySaveWeb.getRegionId()));

        List<Language> languages = countrySaveWeb.getLanguageIds().stream()
                .map(languagueId -> languageRepository.findById(languagueId)
                        .orElseThrow(() -> new ResourceNotFoundException("Language not found with id: " + languagueId)))
                .toList();

        country.setRegion(region);
        country.setLanguages(languages);

        validate(country);
        return repository.save(country);
    }

    @Override
    public void delete(int countryId) {
        repository.findById(countryId)
                        .orElseThrow(() -> new ResourceNotFoundException("Country not found with id: " + countryId));

        repository.delete(countryId);
    }

    @Override
    public List<Country> findCountriesByRegionName(String regionName) {
        return repository.findCountriesByRegionName(regionName);
    }
}
