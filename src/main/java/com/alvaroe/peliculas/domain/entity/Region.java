package com.alvaroe.peliculas.domain.entity;

import jakarta.validation.ValidationException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Region {
    int id;
    String name;
    Continent continent;

    /*public void setContinent(Continent continent) {
        if(this.getName().equals(continent.getName())) {
            throw new ValidationException("El nombre del continente no puede ser igual al de la región.");
        }

        this.continent = continent;
    }*/
}
