package com.courses.api.infrastructure.api.mapper.course;

import com.courses.api.domain.entity.Course;
import com.courses.api.infrastructure.api.dto.response.CourseDetailsResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface CourseDetailsResponseMapper {
  @Mapping(target = "creatorName",source = "creator.name")
  CourseDetailsResponse toResponse(Course course);
}
