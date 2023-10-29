package com.courses.api.infrastructure.api.mapper.course;

import com.courses.api.domain.entity.Course;
import com.courses.api.infrastructure.api.dto.request.CourseRequest;
import org.mapstruct.Mapper;

@Mapper
public interface CourseRequestMapper {
  Course toEntity(CourseRequest courseRequest);
}
