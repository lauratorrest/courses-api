package com.courses.api.infrastructure.api.mapper.sectionclass;

import com.courses.api.domain.entity.SectionClass;
import com.courses.api.infrastructure.api.dto.response.SectionClassResponse;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface SectionClassResponseMapper {
  @Mapping(target = "sectionId", source = "sectionId.id")
  SectionClassResponse toResponse(SectionClass sectionClass);
  List<SectionClassResponse> toResponse(List<SectionClass> sectionClass);
}
