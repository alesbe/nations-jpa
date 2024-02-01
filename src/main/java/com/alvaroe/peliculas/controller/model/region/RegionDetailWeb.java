package com.alvaroe.peliculas.controller.model.region;

import com.alvaroe.peliculas.controller.model.continent.ContinentDetailWeb;
import com.alvaroe.peliculas.domain.entity.Continent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegionDetailWeb {
    int id;
    String name;
    ContinentDetailWeb continent;
}
