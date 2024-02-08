package com.alvaroe.peliculas.domain.entity;

import com.alvaroe.peliculas.common.validation.annotation.ValidArea;
import com.alvaroe.peliculas.common.validation.annotation.ValidLongCountryCode;
import com.alvaroe.peliculas.common.validation.annotation.ValidNationalDay;
import com.alvaroe.peliculas.common.validation.annotation.ValidShortCountryCode;
import jakarta.annotation.Nullable;
import jakarta.validation.ValidationException;
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

    @ValidArea
    float area;

    @ValidNationalDay
    @Nullable
    LocalDate nationalDay;

    @ValidShortCountryCode
    String countryCodeShort;

    @ValidLongCountryCode
    String countryCodeLong;
    Region region;
    List<Language> languages;

    public void setRegion(Region region) {
        if(this.name.equals(region.getName())) {
            throw new ValidationException("El nombre de la región no puede ser igual al del país.");
        }

        this.region = region;
    }
}
