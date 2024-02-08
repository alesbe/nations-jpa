package com.alvaroe.peliculas.controller.model.country;

import com.alvaroe.peliculas.controller.model.language.LanguageDetailWeb;
import com.alvaroe.peliculas.controller.model.region.RegionListWeb;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL) // No incluirá atributos nulos en el JSON
public class CountryDetailWeb {
    int id;
    String name;
    float area;
    LocalDate national_day;
    String country_code;
    String long_country_code;
    RegionListWeb region;
    List<String> languages;
}
