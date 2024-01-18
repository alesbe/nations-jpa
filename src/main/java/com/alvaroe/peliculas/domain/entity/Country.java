package com.alvaroe.peliculas.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Country {
    int id;
    String name;
    float area;
    Date nationalDay;
    String countryCodeShort;
    String countryCodeLong;
    Region region;
    List<Language> languages;
}
