package com.courses.api.infrastructure.repository.course;

import com.courses.api.domain.entity.Course;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper {
  Course toEntity(CourseDto dto);
  List<Course> toEntity(List<CourseDto> dtos);
  CourseDto toDto(Course course);
}
