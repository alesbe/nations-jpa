package com.alvaroe.peliculas.domain.entity;

import com.alvaroe.peliculas.common.validation.annotation.ValidNationalDay;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Country {
    int id;
    String name;
    float area;

    @ValidNationalDay
    LocalDate nationalDay;
    String countryCodeShort;
    String countryCodeLong;
    Region region;
    List<Language> languages;
}
