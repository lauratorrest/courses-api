package com.courses.api.infrastructure.adapter.course;

import com.courses.api.domain.entity.Course;
import com.courses.api.domain.service.course.CourseGetSevice;
import com.courses.api.infrastructure.repository.course.CourseDto;
import com.courses.api.infrastructure.repository.course.CourseMapper;
import com.courses.api.infrastructure.repository.course.CourseRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CourseGetAdapter implements CourseGetSevice {

  private final CourseRepository courseRepository;
  private final CourseMapper courseMapper;

  @Override
  public List<Course> getAllCourses() {
    return courseMapper.toEntity(courseRepository.findAll());
  }

  @Override
  public Course getCourseById(Long id) {
    Optional<CourseDto> dto = courseRepository.findById(id);
    return dto.map(courseMapper::toEntity).orElseThrow(RuntimeException::new);
  }
}
