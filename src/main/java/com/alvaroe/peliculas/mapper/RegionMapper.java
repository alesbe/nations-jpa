package com.alvaroe.peliculas.mapper;

import com.alvaroe.peliculas.controller.model.continent.ContinentDetailWeb;
import com.alvaroe.peliculas.controller.model.region.RegionDetailWeb;
import com.alvaroe.peliculas.controller.model.region.RegionListWeb;
import com.alvaroe.peliculas.controller.model.region.RegionSaveWeb;
import com.alvaroe.peliculas.domain.entity.Continent;
import com.alvaroe.peliculas.domain.entity.Region;
import com.alvaroe.peliculas.persistance.model.ContinentEntity;
import com.alvaroe.peliculas.persistance.model.RegionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RegionMapper {
    RegionMapper mapper = Mappers.getMapper(RegionMapper.class);

    @Mapping(target = "continent", expression = "java(region.getContinent().getName())")
    RegionListWeb toRegionListWeb(Region region);

    @Mapping(target = "continent", expression = "java(continentToContinentDetailWeb(region.getContinent()))")
    RegionDetailWeb toRegionDetailWeb(Region region);

    @Mapping(target = "continent", ignore = true)
    Region toRegion(RegionSaveWeb regionSaveWeb);

    @Mapping(target = "continent", expression = "java(continentEntityToContinent(regionEntity.getContinent()))")
    Region toRegion(RegionEntity regionEntity);

    @Mapping(target = "continent", expression = "java(continentToContinentEntity(region.getContinent()))")
    RegionEntity toRegionEntity(Region region);

    default ContinentEntity continentToContinentEntity(Continent continent) {
        return ContinentMapper.mapper.toContinentEntity(continent);
    }

    default Continent continentEntityToContinent(ContinentEntity continentEntity) {
        return ContinentMapper.mapper.toContinent(continentEntity);
    }

    default ContinentDetailWeb continentToContinentDetailWeb(Continent continent) {
        return ContinentMapper.mapper.toContinentDetailWeb(continent);
    }
}
