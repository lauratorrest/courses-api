package com.courses.api.infrastructure.repository.sectionclass;

import com.courses.api.domain.entity.SectionClass;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SectionClassMapper {
  SectionClass toEntity(SectionClassDto dto);
  List<SectionClass> toEntity(List<SectionClassDto> dtos);

  SectionClassDto toDto(SectionClass sectionClass);
  List<SectionClassDto> toDto(List<SectionClass> sectionClasses);
}
