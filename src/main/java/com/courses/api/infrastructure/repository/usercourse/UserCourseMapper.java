package com.courses.api.infrastructure.repository.usercourse;

import com.courses.api.domain.entity.UserCourse;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper
public interface UserCourseMapper {
  UserCourse toEntity(UserCourseDto userCourseDto);
  List<UserCourse> toEntity(List<UserCourseDto> userCourseDto);
  UserCourseDto toDto(UserCourse userCourse);
}
