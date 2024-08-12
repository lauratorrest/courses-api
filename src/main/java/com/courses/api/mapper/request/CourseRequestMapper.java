package com.courses.api.mapper.request;

import com.courses.api.dto.request.CourseDetailedRequest;
import com.courses.api.dto.request.CourseRequest;
import com.courses.model.Course;
import com.courses.model.enums.LanguageEnum;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CourseRequestMapper {

  CourseRequestMapper INSTANCE = Mappers.getMapper(CourseRequestMapper.class);

  Course toModel(CourseRequest courseRequest);

  @Mapping(source = "language", target = "language", qualifiedByName = "mapLanguage")
  Course toModel(CourseDetailedRequest courseDetailedRequest);

  @Named("mapLanguage")
  default LanguageEnum mapLanguage(String value) {
    return value != null
        ? LanguageEnum.valueOf(value)
        : null;
  }
}
