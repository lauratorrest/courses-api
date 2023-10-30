package com.courses.api.infrastructure.api.mapper.section;

import com.courses.api.domain.entity.Section;
import com.courses.api.infrastructure.api.dto.request.SectionRequest;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper
public interface SectionRequestMapper {
  Section toEntity(SectionRequest sectionRequest);
  List<Section> toEntity(List<SectionRequest> sectionRequest);
}
