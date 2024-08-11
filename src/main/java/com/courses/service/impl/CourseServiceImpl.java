package com.courses.service.impl;

import com.courses.model.Course;
import com.courses.repository.course.CourseRepository;
import com.courses.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {

  private final CourseRepository courseRepository;

  public void saveCourse(Course course) {
    courseRepository.save(course);
  }
}
