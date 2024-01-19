package com.alvaroe.peliculas.mapper;

import com.alvaroe.peliculas.controller.model.country.CountryDetailWeb;
import com.alvaroe.peliculas.controller.model.country.CountryListWeb;
import com.alvaroe.peliculas.domain.entity.Country;
import com.alvaroe.peliculas.persistance.model.CountryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CountryMapper {
    CountryMapper mapper = Mappers.getMapper(CountryMapper.class);

    Country toCountry(CountryEntity countryEntity);

    @Mapping(target = "region", expression = "java(country.getRegion().getName())")
    CountryListWeb toCountryListWeb(Country country);

    @Mapping(target = "national_day", source = "country.nationalDay")
    @Mapping(target = "country_code", source = "country.countryCodeShort")
    @Mapping(target = "long_country_code", source = "country.countryCodeLong")
    CountryDetailWeb toCountryDetailWeb(Country country);
}
