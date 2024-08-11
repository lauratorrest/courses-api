package com.courses.api.service.course;

import com.courses.api.model.Course;
import com.courses.api.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CourseService {

  private final CourseRepository courseRepository;

  public void saveCourse(Course course) {
    courseRepository.save(course);
  }
}
