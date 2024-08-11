package com.courses.api.controller;

import com.courses.model.Course;
import com.courses.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/course")
public class CourseController {

  private final CourseService courseService;

  @PostMapping
  public void saveCourse(@RequestBody Course course) {
    courseService.saveCourse(course);
  }
}
