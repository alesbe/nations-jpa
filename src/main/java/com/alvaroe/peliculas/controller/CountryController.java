package com.alvaroe.peliculas.controller;

import com.alvaroe.peliculas.controller.model.country.CountryDetailWeb;
import com.alvaroe.peliculas.controller.model.country.CountryListWeb;
import com.alvaroe.peliculas.controller.model.country.CountrySaveWeb;
import com.alvaroe.peliculas.domain.service.CountryService;
import com.alvaroe.peliculas.http_response.Response;
import com.alvaroe.peliculas.mapper.CountryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    CountryService service;

    @Value("${page.size}")
    private int PAGE_SIZE;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public Response getAll(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer pageSize) {
        pageSize = (pageSize != null) ? pageSize : PAGE_SIZE;

        List<CountryListWeb> countries = (page == null)
                        ?
                        service.getAll().stream().map(CountryMapper.mapper::toCountryListWeb).toList()
                        :
                        service.getAll(page, pageSize).stream().map(CountryMapper.mapper::toCountryListWeb).toList();

        return Response.builder().data(countries).totalRecords(countries.size()).build();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Response findById(@PathVariable("id") Integer id) {
        return Response.builder().data(CountryMapper.mapper.toCountryDetailWeb(service.findById(id))).build();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public Response save(@RequestBody CountrySaveWeb countrySaveWeb) {
        int id = service.save(countrySaveWeb);

        countrySaveWeb.setId(id);

        return Response.builder().data(CountryMapper.mapper.toCountryDetailWeb(service.findById(countrySaveWeb.getId()))).build();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("")
    public Response update(@RequestBody CountrySaveWeb countrySaveWeb) {
        service.save(countrySaveWeb);

        return Response.builder().data(CountryMapper.mapper.toCountryDetailWeb(service.findById(countrySaveWeb.getId()))).build();
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer countryId) {
        service.delete(countryId);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("findCountriesByRegionName/{regionName}")
    public Response findCountriesByRegionName(@PathVariable("regionName") String regionName) {
        List<CountryListWeb> countries = service.findCountriesByRegionName(regionName).stream()
                .map(CountryMapper.mapper::toCountryListWeb)
                .toList();

        return Response.builder().data(countries).build();
    }
}
