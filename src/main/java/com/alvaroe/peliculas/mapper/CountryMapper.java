package com.alvaroe.peliculas.mapper;

import com.alvaroe.peliculas.controller.model.country.CountryDetailWeb;
import com.alvaroe.peliculas.controller.model.country.CountryListWeb;
import com.alvaroe.peliculas.domain.entity.Country;
import com.alvaroe.peliculas.domain.entity.Language;
import com.alvaroe.peliculas.persistance.model.CountryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CountryMapper {
    CountryMapper mapper = Mappers.getMapper(CountryMapper.class);

    Country toCountry(CountryEntity countryEntity);

    @Mapping(target = "region", expression = "java(country.getRegion().getName())")
    CountryListWeb toCountryListWeb(Country country);

    @Mapping(target = "national_day", source = "country.nationalDay")
    @Mapping(target = "country_code", source = "country.countryCodeShort")
    @Mapping(target = "long_country_code", source = "country.countryCodeLong")
    @Mapping(target = "languages", expression = "java(languageListToStringList(country.getLanguages()))")
    CountryDetailWeb toCountryDetailWeb(Country country);

    default List<String> languageListToStringList(List<Language> languages) {
        return languages.stream()
                .map(Language::getLanguage)
                .toList();
    }
}
