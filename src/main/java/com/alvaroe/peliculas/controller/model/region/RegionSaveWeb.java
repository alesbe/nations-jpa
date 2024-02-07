package com.alvaroe.peliculas.controller.model.region;

import com.alvaroe.peliculas.controller.model.continent.ContinentDetailWeb;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegionSaveWeb {
    int id;
    String name;
    Integer continentId;
}

