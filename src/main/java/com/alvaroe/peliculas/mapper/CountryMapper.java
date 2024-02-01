package com.alvaroe.peliculas.mapper;

import com.alvaroe.peliculas.controller.model.country.CountryDetailWeb;
import com.alvaroe.peliculas.controller.model.country.CountryListWeb;
import com.alvaroe.peliculas.controller.model.country.CountrySaveWeb;
import com.alvaroe.peliculas.controller.model.region.RegionListWeb;
import com.alvaroe.peliculas.domain.entity.Country;
import com.alvaroe.peliculas.domain.entity.Language;
import com.alvaroe.peliculas.domain.entity.Region;
import com.alvaroe.peliculas.persistance.model.CountryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CountryMapper {
    CountryMapper mapper = Mappers.getMapper(CountryMapper.class);

    // To Web entity
    @Mapping(target = "region", expression = "java(country.getRegion().getName())")
    CountryListWeb toCountryListWeb(Country country);

    @Mapping(target = "national_day", source = "country.nationalDay")
    @Mapping(target = "country_code", source = "country.countryCodeShort")
    @Mapping(target = "long_country_code", source = "country.countryCodeLong")
    @Mapping(target = "region", expression = "java(regionToRegionListWeb(country.getRegion()))")
    @Mapping(target = "languages", expression = "java(languageListToStringList(country.getLanguages()))")
    CountryDetailWeb toCountryDetailWeb(Country country);

    @Mapping(target = "national_day", source = "country.nationalDay")
    @Mapping(target = "country_code", source = "country.countryCodeShort")
    @Mapping(target = "long_country_code", source = "country.countryCodeLong")
    @Mapping(target = "regionId", ignore = true)
    @Mapping(target = "languageIds", ignore = true)
    CountrySaveWeb toCountrySaveWeb(Country country);

    // To domain entity

    @Mapping(target = "nationalDay", source = "countrySaveWeb.national_day")
    @Mapping(target = "countryCodeShort ", source = "countrySaveWeb.country_code")
    @Mapping(target = "countryCodeLong", source = "countrySaveWeb.long_country_code")
    @Mapping(target = "region", ignore = true)
    @Mapping(target = "languages", ignore = true)
    Country toCountry(CountrySaveWeb countrySaveWeb);

    Country toCountry(CountryEntity countryEntity);

    // To persistance entity
    CountryEntity toCountryEntity(Country country);

    default RegionListWeb regionToRegionListWeb(Region region) {
        return RegionMapper.mapper.toRegionListWeb(region);
    }

    default List<String> languageListToStringList(List<Language> languages) {
        return languages.stream()
                .map(Language::getLanguage)
                .toList();
    }
}
