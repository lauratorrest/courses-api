package com.courses.api.infrastructure.api.mapper.sectionclass;

import com.courses.api.domain.entity.SectionClass;
import com.courses.api.infrastructure.api.dto.request.SectionClassRequest;
import org.mapstruct.Mapper;

@Mapper
public interface SectionClassRequestMapper {
  SectionClass toEntity(SectionClassRequest sectionClassRequest);
}
