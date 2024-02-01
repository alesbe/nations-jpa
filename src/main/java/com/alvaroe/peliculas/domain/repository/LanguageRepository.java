package com.alvaroe.peliculas.domain.repository;

import com.alvaroe.peliculas.domain.entity.Language;
import com.alvaroe.peliculas.domain.entity.Region;

import java.util.List;
import java.util.Optional;

public interface LanguageRepository {
    public List<Language> getAll(Integer page, Integer pageSize);
    public Optional<Language> findById(Integer id);
    public int save(Language language);
}
