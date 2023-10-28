package com.courses.api.application.course;

import com.courses.api.domain.entity.Course;
import com.courses.api.domain.service.course.CourseGetSevice;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CourseGetApplication {
  private final CourseGetSevice courseGetSevice;

  public List<Course> getAllCourses(){
    return courseGetSevice.getAllCourses();
  }

  public Course getById(Long id){
    return courseGetSevice.getCourseById(id);
  }
}
