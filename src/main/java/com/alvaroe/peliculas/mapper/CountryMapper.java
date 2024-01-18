package com.alvaroe.peliculas.mapper;

import com.alvaroe.peliculas.controller.model.country.CountryListWeb;
import com.alvaroe.peliculas.domain.entity.Country;
import com.alvaroe.peliculas.persistance.model.CountryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CountryMapper {
    CountryMapper mapper = Mappers.getMapper(CountryMapper.class);

    // TODO: Fix mappers, add default methods to map lazy entities
    Country toCountry(CountryEntity countryEntity);

    @Mapping(target = "region", expression = "java(country.getRegion().getName())")
    CountryListWeb toCountryListWeb(Country country);
}
