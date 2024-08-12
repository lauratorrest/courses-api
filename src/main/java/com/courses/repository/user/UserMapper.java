package com.courses.repository.user;

import com.courses.model.Course;
import com.courses.model.User;
import java.util.List;
import java.util.stream.Collectors;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

  UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

  @Mapping(source = "madeCourses", target = "madeCoursesIds", qualifiedByName = "mapCoursesIds")
  @Mapping(source = "boughtCourses", target = "boughtCoursesIds", qualifiedByName = "mapCoursesIds")
  UserDto toDto(User user);

  @Mapping(source = "madeCoursesIds", target = "madeCourses", qualifiedByName = "mapCourses")
  User toEntity(UserDto userDto);

  @Named("mapCoursesIds")
  default List<String> mapCoursesIds(List<Course> courses) {
    return courses != null
        ? courses.stream().map(Course::getId).collect(Collectors.toList())
        : null;
  }

  @Named("mapCourses")
  default List<Course> mapCourses(List<String> coursesIds) {
    return coursesIds != null
        ? coursesIds.stream().map(id -> Course.builder().id(id).build())
        .collect(Collectors.toList())
        : null;
  }
}
