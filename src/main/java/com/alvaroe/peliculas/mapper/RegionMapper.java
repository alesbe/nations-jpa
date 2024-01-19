package com.alvaroe.peliculas.mapper;

import com.alvaroe.peliculas.controller.model.region.RegionListWeb;
import com.alvaroe.peliculas.domain.entity.Region;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RegionMapper {
    RegionMapper mapper = Mappers.getMapper(RegionMapper.class);

    @Mapping(target = "continent", expression = "java(region.getContinent().getName())")
    RegionListWeb toRegionListWeb(Region region);
}
