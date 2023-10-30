package com.courses.api.infrastructure.repository.section;

import com.courses.api.domain.entity.Section;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper
public interface SectionMapper {
  Section toEntity(SectionDto dto);
  List<Section> toEntity(List<SectionDto> dtos);

  SectionDto toDto(Section section);
  List<SectionDto> toDto(List<Section> sections);
}
