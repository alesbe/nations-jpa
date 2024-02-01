package com.alvaroe.peliculas.persistance.impl;

import com.alvaroe.peliculas.domain.entity.Country;
import com.alvaroe.peliculas.domain.entity.Language;
import com.alvaroe.peliculas.domain.entity.Region;
import com.alvaroe.peliculas.domain.repository.LanguageRepository;
import com.alvaroe.peliculas.mapper.CountryMapper;
import com.alvaroe.peliculas.mapper.LanguageMapper;
import com.alvaroe.peliculas.mapper.RegionMapper;
import com.alvaroe.peliculas.persistance.dao.LanguageDAO;
import com.alvaroe.peliculas.persistance.dao.RegionDAO;
import com.alvaroe.peliculas.persistance.model.LanguageEntity;
import com.alvaroe.peliculas.persistance.model.RegionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class LanguageRepositoryImpl implements LanguageRepository {
    @Autowired
    LanguageDAO languageDAO;

    @Override
    public List<Language> getAll(Integer page, Integer pageSize) {
        List<LanguageEntity> languageEntities;

        if(page != null && page > 0) {
            Pageable pageable = PageRequest.of(page - 1, pageSize);
            languageEntities = languageDAO.findAll(pageable).stream().toList();
        } else {
            languageEntities = languageDAO.findAll();
        }

        return languageEntities.stream().map(LanguageMapper.mapper::toLanguage).toList();
    }

    @Override
    public Optional<Language> findById(Integer id) {
        Optional<LanguageEntity> languageEntity = languageDAO.findById(id);

        if(languageEntity.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(LanguageMapper.mapper.toLanguage(languageEntity.get()));
    }

    @Override
    public int save(Language language) {
        return languageDAO.save(LanguageMapper.mapper.toLanguageEntity(language)).getId();
    }

    @Override
    public void delete(int languageId) {
        languageDAO.deleteById(languageId);
    }
}
