package com.courses.api.mapper.request;

import com.courses.api.dto.request.SectionRequest;
import com.courses.model.Section;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SectionRequestMapper {

    SectionRequestMapper INSTANCE = Mappers.getMapper(SectionRequestMapper.class);

    Section toEntity(SectionRequest sectionRequest);
}
