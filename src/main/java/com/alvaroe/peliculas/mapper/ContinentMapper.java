package com.alvaroe.peliculas.mapper;

import com.alvaroe.peliculas.domain.entity.Continent;
import com.alvaroe.peliculas.domain.entity.Country;
import com.alvaroe.peliculas.persistance.model.ContinentEntity;
import com.alvaroe.peliculas.persistance.model.CountryEntity;
import org.mapstruct.factory.Mappers;

public interface ContinentMapper {
    ContinentMapper mapper = Mappers.getMapper(ContinentMapper.class);

    Continent toContinent(ContinentEntity continentEntity);
}
