package com.courses.api.domain.service.course;

import com.courses.api.domain.entity.Course;
import java.util.List;

public interface CourseGetSevice {
  List<Course> getAllCourses();
  Course getCourseById(Long id);
}
