package com.courses.api.infrastructure.adapter.course;

import com.courses.api.domain.entity.Course;
import com.courses.api.domain.service.course.CourseSaveService;
import com.courses.api.infrastructure.repository.course.CourseMapper;
import com.courses.api.infrastructure.repository.course.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CourseSaveAdapter implements CourseSaveService {

  private final CourseRepository courseRepository;
  private final CourseMapper courseMapper;

  @Override
  public Course saveCourse(Course course) {
    return courseMapper.toEntity(courseRepository.save(courseMapper.toDto(course)));
  }
}
