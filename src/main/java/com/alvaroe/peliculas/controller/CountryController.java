package com.alvaroe.peliculas.controller;

import com.alvaroe.peliculas.controller.model.country.CountryListWeb;
import com.alvaroe.peliculas.domain.service.CountryService;
import com.alvaroe.peliculas.http_response.Response;
import com.alvaroe.peliculas.mapper.CountryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
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
    public Response getAll() {
        List<CountryListWeb> countries = service.getAll(1, 10).stream()
                .map(CountryMapper.mapper::toCountryListWeb).toList();

        return Response.builder().data(countries).build();
        //return null;
    }
}
