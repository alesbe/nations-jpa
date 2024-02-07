package com.alvaroe.peliculas.mapper;

import com.alvaroe.peliculas.controller.model.continent.ContinentDetailWeb;
import com.alvaroe.peliculas.domain.entity.Continent;
import com.alvaroe.peliculas.domain.entity.Country;
import com.alvaroe.peliculas.persistance.model.ContinentEntity;
import com.alvaroe.peliculas.persistance.model.CountryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ContinentMapper {
    ContinentMapper mapper = Mappers.getMapper(ContinentMapper.class);

    ContinentDetailWeb toContinentDetailWeb(Continent continent);
    Continent toContinent(ContinentEntity continentEntity);
    ContinentEntity toContinentEntity(Continent continent);

}
