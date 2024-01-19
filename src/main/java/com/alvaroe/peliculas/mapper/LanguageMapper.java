package com.alvaroe.peliculas.mapper;

import com.alvaroe.peliculas.controller.model.language.LanguageDetailWeb;
import com.alvaroe.peliculas.domain.entity.Language;
import com.alvaroe.peliculas.persistance.model.LanguageEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface LanguageMapper {
    LanguageMapper mapper = Mappers.getMapper(LanguageMapper.class);

    Language toLanguage(LanguageEntity languageEntity);
    LanguageDetailWeb toLanguageDetailWeb(Language language);
}
