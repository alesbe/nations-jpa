package com.alvaroe.peliculas.controller;

import com.alvaroe.peliculas.controller.model.country.CountryListWeb;
import com.alvaroe.peliculas.controller.model.country.CountrySaveWeb;
import com.alvaroe.peliculas.controller.model.language.LanguageDetailWeb;
import com.alvaroe.peliculas.controller.model.language.LanguageSaveWeb;
import com.alvaroe.peliculas.domain.service.CountryService;
import com.alvaroe.peliculas.domain.service.LanguageService;
import com.alvaroe.peliculas.http_response.Response;
import com.alvaroe.peliculas.mapper.CountryMapper;
import com.alvaroe.peliculas.mapper.LanguageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/language")
public class LanguageController {

    @Autowired
    LanguageService service;

    @Value("${page.size}")
    private int PAGE_SIZE;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public Response getAll(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer pageSize) {
        pageSize = (pageSize != null) ? pageSize : PAGE_SIZE;

        List<LanguageDetailWeb> languages = (page == null)
                ?
                service.getAll().stream().map(LanguageMapper.mapper::toLanguageDetailWeb).toList()
                :
                service.getAll(page, pageSize).stream().map(LanguageMapper.mapper::toLanguageDetailWeb).toList();

        return Response.builder().data(languages).totalRecords(languages.size()).build();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public Response save(@RequestBody LanguageSaveWeb languageSaveWeb) {
        int id = service.save(languageSaveWeb);

        languageSaveWeb.setId(id);

        return Response.builder().data(LanguageMapper.mapper.toLanguageDetailWeb(service.findById(languageSaveWeb.getId()))).build();
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer countryId) {
        service.delete(countryId);
    }
}
