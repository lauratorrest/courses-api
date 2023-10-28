package com.courses.api.infrastructure.api.mapper.course;

import com.courses.api.domain.entity.Course;
import com.courses.api.infrastructure.api.dto.response.CourseResponse;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CourseResponseMapper {
  @Mapping(target = "creatorName", source = "creator.name")
  CourseResponse toResponse(Course course);
  List<CourseResponse> toResponse(List<Course> courses);
}
