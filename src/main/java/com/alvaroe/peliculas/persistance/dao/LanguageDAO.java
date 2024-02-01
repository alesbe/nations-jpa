package com.alvaroe.peliculas.persistance.dao;

import com.alvaroe.peliculas.persistance.model.LanguageEntity;
import com.alvaroe.peliculas.persistance.model.RegionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface LanguageDAO extends JpaRepository<LanguageEntity, Integer> {
    Page<LanguageEntity> findAll(Pageable pageable);
    List<LanguageEntity> findAll();
    Optional<LanguageEntity> findById(Integer id);
}
