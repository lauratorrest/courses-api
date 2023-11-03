package com.courses.api.infrastructure.api.mapper.section;

import com.courses.api.domain.entity.Section;
import com.courses.api.infrastructure.api.dto.response.SectionResponse;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface SectionResponseMapper {
  @Mapping(target = "courseId", source = "courseId.id")
  SectionResponse toResponse(Section section);
  List<SectionResponse> toResponse(List<Section> section);
}
