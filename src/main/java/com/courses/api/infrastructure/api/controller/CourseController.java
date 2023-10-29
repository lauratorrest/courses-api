package com.courses.api.infrastructure.api.controller;

import com.courses.api.application.course.CourseGetApplication;
import com.courses.api.application.course.CourseSaveApplication;
import com.courses.api.domain.entity.Course;
import com.courses.api.infrastructure.api.dto.request.CourseRequest;
import com.courses.api.infrastructure.api.dto.response.CourseDetailsResponse;
import com.courses.api.infrastructure.api.dto.response.CourseBasicResponse;
import com.courses.api.infrastructure.api.mapper.course.CourseDetailsResponseMapper;
import com.courses.api.infrastructure.api.mapper.course.CourseRequestMapper;
import com.courses.api.infrastructure.api.mapper.course.CourseResponseMapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/courses")
public class CourseController {
  private final CourseGetApplication courseGetApplication;
  private final CourseSaveApplication courseSaveApplication;
  private final CourseRequestMapper courseRequestMapper;
  private final CourseResponseMapper courseResponseMapper;
  private final CourseDetailsResponseMapper detailsResponseMapper;

  @GetMapping
  public ResponseEntity<List<CourseBasicResponse>> getAllCourses(){
    List<Course> courses = courseGetApplication.getAllCourses();

    List<CourseBasicResponse> responses = new ArrayList<>();

    for(Course course : courses){
      CourseBasicResponse basicResponse = courseResponseMapper.toResponse(course);
      List<String> skills = Arrays.asList(course.getSkillsToLearn().split(","));
      List<String> limitedSkills = skills.subList(0, Math.min(3, skills.size()));
      basicResponse.setSkillsToLearnList(limitedSkills);
      responses.add(basicResponse);
    }

    return ResponseEntity.ok(responses);
  }

  @GetMapping("/{id}")
  public ResponseEntity<CourseDetailsResponse> getCourseBydId(@PathVariable("id") Long id){
    Course course = courseGetApplication.getById(id);

    CourseDetailsResponse response = detailsResponseMapper.toResponse(course);
    response.setSkillsToLearnList(Arrays.asList(course.getSkillsToLearn().split(",")));
    response.setRequirementsList(Arrays.asList(course.getRequirements().split(",")));
    response.setCourseIsForList(Arrays.asList(course.getCourseIsFor().split(",")));

    return ResponseEntity.ok(response);
  }

  @PostMapping
  public ResponseEntity<String> saveCourse(@RequestBody CourseRequest request, @RequestHeader("USER_ID") Long id){
    courseSaveApplication.saveCourse(courseRequestMapper.toEntity(request), id);
    return ResponseEntity.ok("¡El curso fue creado con éxito!");
  }

}
