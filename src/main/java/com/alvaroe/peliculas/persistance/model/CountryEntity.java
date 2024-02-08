package com.alvaroe.peliculas.persistance.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "countries")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    int id;
    String name;

    float area;

    @Column(name = "national_day", nullable = true)
    LocalDate nationalDay;

    @Column(name = "country_code2")
    String countryCodeShort;

    @Column(name = "country_code3")
    String countryCodeLong;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    RegionEntity region;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "country_languages",
            joinColumns = @JoinColumn(name = "country_id"),
            inverseJoinColumns = @JoinColumn(name = "language_id")
    )
    List<LanguageEntity> languages;
}
