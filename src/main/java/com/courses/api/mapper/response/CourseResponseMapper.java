package com.courses.api.mapper.response;

import com.courses.api.dto.response.CourseBasicResponse;
import com.courses.api.dto.response.CourseDetailedResponse;
import com.courses.model.Course;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CourseResponseMapper {

    CourseResponseMapper INSTANCE = Mappers.getMapper(CourseResponseMapper.class);

    CourseBasicResponse toResponse(Course course);

    List<CourseBasicResponse> toResponse(List<Course> courses);

    CourseDetailedResponse toDetailedResponse(Course course);
}
