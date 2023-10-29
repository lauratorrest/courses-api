package com.courses.api.application.course;

import com.courses.api.domain.entity.Course;
import com.courses.api.domain.entity.User;
import com.courses.api.domain.service.course.CourseSaveService;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CourseSaveApplication {
  private final CourseSaveService courseSaveService;

  public Course saveCourse(Course course, Long creatorId){
    User user = new User();
    user.setId(creatorId);
    course.setCreator(user);
    course.setCreatedDate(LocalDateTime.now());
    course.setUpdatedDate(LocalDateTime.now());
    course.setPunctuation(0.0);
    course.setGradeCount(0);
    course.setStudentsCount(0);

    return courseSaveService.saveCourse(course);
  }
}
