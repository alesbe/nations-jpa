package com.alvaroe.peliculas.controller;

import com.alvaroe.peliculas.controller.model.country.CountryListWeb;
import com.alvaroe.peliculas.controller.model.country.CountrySaveWeb;
import com.alvaroe.peliculas.controller.model.region.RegionListWeb;
import com.alvaroe.peliculas.controller.model.region.RegionSaveWeb;
import com.alvaroe.peliculas.domain.entity.Region;
import com.alvaroe.peliculas.domain.service.CountryService;
import com.alvaroe.peliculas.domain.service.RegionService;
import com.alvaroe.peliculas.http_response.Response;
import com.alvaroe.peliculas.mapper.CountryMapper;
import com.alvaroe.peliculas.mapper.RegionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/region")
public class RegionController {

    @Autowired
    RegionService service;

    @Value("${page.size}")
    private int PAGE_SIZE;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public Response getAll(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer pageSize) {
        pageSize = (pageSize != null) ? pageSize : PAGE_SIZE;

        List<RegionListWeb> regions = (page == null)
                ?
                service.getAll().stream().map(RegionMapper.mapper::toRegionListWeb).toList()
                :
                service.getAll(page, pageSize).stream().map(RegionMapper.mapper::toRegionListWeb).toList();

        return Response.builder().data(regions).totalRecords(regions.size()).build();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Response findById(@PathVariable("id") Integer id) {
        return Response.builder().data(RegionMapper.mapper.toRegionDetailWeb(service.findById(id))).build();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public Response add(@RequestBody RegionSaveWeb regionSaveWeb) {
        int id = service.save(regionSaveWeb);

        regionSaveWeb.setId(id);

        return Response.builder().data(RegionMapper.mapper.toRegionDetailWeb(service.findById(regionSaveWeb.getId()))).build();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("")
    public Response update(@RequestBody RegionSaveWeb regionSaveWeb) {
        service.save(regionSaveWeb);
        return Response.builder().data(RegionMapper.mapper.toRegionDetailWeb(service.findById(regionSaveWeb.getId()))).build();
    }
}
