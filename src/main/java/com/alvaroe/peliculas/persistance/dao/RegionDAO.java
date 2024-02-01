package com.alvaroe.peliculas.persistance.dao;

import com.alvaroe.peliculas.persistance.model.CountryEntity;
import com.alvaroe.peliculas.persistance.model.RegionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface RegionDAO extends JpaRepository<RegionEntity, Integer> {
    Page<RegionEntity> findAll(Pageable pageable);
    List<RegionEntity> findAll();
    Optional<RegionEntity> findById(Integer id);
}
