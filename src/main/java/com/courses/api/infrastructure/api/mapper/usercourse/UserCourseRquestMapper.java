package com.courses.api.infrastructure.api.mapper.usercourse;

import com.courses.api.domain.entity.UserCourse;
import com.courses.api.infrastructure.api.dto.request.UserCourseRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface UserCourseRquestMapper {
  @Mapping(target = "course.id", source = "courseId")
  UserCourse toEntity(UserCourseRequest request);
}
