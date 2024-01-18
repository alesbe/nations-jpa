package com.alvaroe.peliculas.controller.model.country;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryListWeb {
    int id;
    String name;
    String region;
}
