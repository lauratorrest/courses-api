package com.courses.api.infrastructure.api.mapper.section;

import com.courses.api.domain.entity.Section;
import com.courses.api.infrastructure.api.dto.response.SectionResponse;
import org.mapstruct.Mapper;

@Mapper
public interface SectionResponseMapper {
  SectionResponse toResponse(Section section);
}
