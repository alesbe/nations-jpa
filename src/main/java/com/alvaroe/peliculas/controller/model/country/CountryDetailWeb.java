package com.alvaroe.peliculas.controller.model.country;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryDetailWeb {
    int id;
    String name;
    float area;
    Date national_day;
    String country_code;
    String long_country_code;

    // TODO: Add region and languages
}
