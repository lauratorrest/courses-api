package com.courses.repository.section;

import com.courses.model.Section;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SectionMapper {

  SectionMapper INSTANCE = Mappers.getMapper(SectionMapper.class);

  Section toEntity(SectionDto sectionDto);

  SectionDto toDto(Section section);
}
