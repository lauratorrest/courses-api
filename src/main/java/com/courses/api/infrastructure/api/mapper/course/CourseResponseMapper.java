package com.courses.api.infrastructure.api.mapper.course;

import com.courses.api.domain.entity.Course;
import com.courses.api.infrastructure.api.dto.response.CourseBasicResponse;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CourseResponseMapper {
  @Mapping(target = "creatorName", source = "creator.name")
  CourseBasicResponse toResponse(Course course);
  List<CourseBasicResponse> toResponse(List<Course> courses);
}
