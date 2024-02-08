package com.alvaroe.peliculas.controller;

import com.alvaroe.peliculas.controller.model.continent.ContinentDetailWeb;
import com.alvaroe.peliculas.controller.model.continent.ContinentSaveWeb;
import com.alvaroe.peliculas.controller.model.country.CountrySaveWeb;
import com.alvaroe.peliculas.controller.model.region.RegionListWeb;
import com.alvaroe.peliculas.domain.service.ContinentService;
import com.alvaroe.peliculas.domain.service.RegionService;
import com.alvaroe.peliculas.http_response.Response;
import com.alvaroe.peliculas.mapper.ContinentMapper;
import com.alvaroe.peliculas.mapper.RegionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/continent")
public class ContinentController {

    @Autowired
    ContinentService service;

    @Value("${page.size}")
    private int PAGE_SIZE;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public Response getAll(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer pageSize) {
        pageSize = (pageSize != null) ? pageSize : PAGE_SIZE;

        List<ContinentDetailWeb> continents = (page == null)
                ?
                service.getAll().stream().map(ContinentMapper.mapper::toContinentDetailWeb).toList()
                :
                service.getAll(page, pageSize).stream().map(ContinentMapper.mapper::toContinentDetailWeb).toList();

        return Response.builder().data(continents).totalRecords(continents.size()).build();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Response findById(@PathVariable("id") Integer id) {
        return Response.builder().data(ContinentMapper.mapper.toContinentDetailWeb(service.findById(id))).build();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public Response save(@RequestBody ContinentSaveWeb continentSaveWeb) {
        int id = service.save(continentSaveWeb);

        continentSaveWeb.setId(id);

        return Response.builder().data(continentSaveWeb).build();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("")
    public Response update(@RequestBody ContinentSaveWeb continentSaveWeb) {
        service.save(continentSaveWeb);

        return Response.builder().data(continentSaveWeb).build();
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer continentId) {
        service.delete(continentId);
    }
}
