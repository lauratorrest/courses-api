package com.courses.repository.course;

import com.courses.model.Course;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CourseMapper {

  CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);

  CourseDto toDto(Course course);

  Course toEntity(CourseDto courseDto);
}
