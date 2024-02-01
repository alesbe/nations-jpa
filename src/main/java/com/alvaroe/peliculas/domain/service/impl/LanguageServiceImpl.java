package com.alvaroe.peliculas.domain.service.impl;

import com.alvaroe.peliculas.controller.model.country.CountrySaveWeb;
import com.alvaroe.peliculas.controller.model.language.LanguageSaveWeb;
import com.alvaroe.peliculas.domain.entity.Country;
import com.alvaroe.peliculas.domain.entity.Language;
import com.alvaroe.peliculas.domain.entity.Region;
import com.alvaroe.peliculas.domain.repository.LanguageRepository;
import com.alvaroe.peliculas.domain.service.LanguageService;
import com.alvaroe.peliculas.exception.ResourceNotFoundException;
import com.alvaroe.peliculas.mapper.CountryMapper;
import com.alvaroe.peliculas.mapper.LanguageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageServiceImpl implements LanguageService {
    @Autowired
    LanguageRepository repository;

    @Override
    public List<Language> getAll(Integer page, Integer pageSize) {
        return repository.getAll(page, pageSize);
    }

    @Override
    public List<Language> getAll() {
        return repository.getAll(null, null);
    }

    @Override
    public Language findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Language not found with id: " + id));
    }

    @Override
    public int save(LanguageSaveWeb languageSaveWeb) {
        return repository.save(LanguageMapper.mapper.toLanguage(languageSaveWeb));
    }

    @Override
    public void delete(int countryId) {
        repository.findById(countryId)
                .orElseThrow(() -> new ResourceNotFoundException("Country not found with id: " + countryId));

        repository.delete(countryId);
    }
}
