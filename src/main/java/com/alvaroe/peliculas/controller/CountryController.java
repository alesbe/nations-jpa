package com.alvaroe.peliculas.controller;

import com.alvaroe.peliculas.controller.model.country.CountryListWeb;
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
        return Response.builder().data(service.findById(id)).build();
    }
}
