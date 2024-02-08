package com.alvaroe.peliculas.persistance.dao;

import com.alvaroe.peliculas.persistance.model.ContinentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface ContinentDAO extends JpaRepository<ContinentEntity, Integer> {
    Page<ContinentEntity> findAll(Pageable pageable);
    List<ContinentEntity> findAll();
    Optional<ContinentEntity> findById(Integer id);
    ContinentEntity save(ContinentEntity continentEntity);
    void deleteById(int continentId);
}
