package com.alvaroe.peliculas.controller.model.region;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegionListWeb {
    int id;
    String name;
    String continent;
}
