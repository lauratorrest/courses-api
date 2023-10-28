package com.courses.api.infrastructure.api.controller;

import com.courses.api.application.course.CourseGetApplication;
import com.courses.api.infrastructure.api.dto.response.CourseDetailsResponse;
import com.courses.api.infrastructure.api.dto.response.CourseResponse;
import com.courses.api.infrastructure.api.mapper.course.CourseDetailsResponseMapper;
import com.courses.api.infrastructure.api.mapper.course.CourseResponseMapper;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/courses")
public class CourseController {
  private final CourseGetApplication courseGetApplication;
  private final CourseResponseMapper courseResponseMapper;
  private final CourseDetailsResponseMapper detailsResponseMapper;

  @GetMapping
  public ResponseEntity<List<CourseResponse>> getAllCourses(){
    return ResponseEntity.ok(courseResponseMapper.toResponse(
        courseGetApplication.getAllCourses()
    ));
  }

  @GetMapping("/{id}")
  public ResponseEntity<CourseDetailsResponse> getCourseBydId(@PathVariable("id") Long id){
    return ResponseEntity.ok(detailsResponseMapper.toResponse(courseGetApplication.getById(id)));
  }
}
