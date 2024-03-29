package com.alvaroe.peliculas.persistance.dao;

import com.alvaroe.peliculas.persistance.model.CountryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface CountryDAO extends JpaRepository<CountryEntity, Integer> {
    Page<CountryEntity> findAll(Pageable pageable);
    List<CountryEntity> findAll();
    Optional<CountryEntity> findById(Integer id);
    CountryEntity save(CountryEntity countryEntity);
    void deleteById(int countryId);


    @Query(value = "SELECT c FROM CountryEntity c WHERE c.region.name = :regionName")
    List<CountryEntity> findCountriesByRegionName(@Param("regionName") String regionName);
}
