package com.courses.api.mapper.response;

import com.courses.api.dto.response.SectionResponse;
import com.courses.model.Section;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SectionResponseMapper {

    SectionResponseMapper INSTANCE = Mappers.getMapper(SectionResponseMapper.class);

    SectionResponse toResponse(Section section);
}
