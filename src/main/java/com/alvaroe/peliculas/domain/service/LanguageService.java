package com.alvaroe.peliculas.domain.service;

import com.alvaroe.peliculas.domain.entity.Language;
import com.alvaroe.peliculas.domain.entity.Region;

import java.util.List;

public interface LanguageService {
    List<Language> getAll(Integer page, Integer pageSize);
    List<Language> getAll();
    Language findById(Integer id);
}
