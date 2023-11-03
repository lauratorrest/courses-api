package com.courses.api.infrastructure.api.controller;

import com.courses.api.application.course.CourseGetApplication;
import com.courses.api.application.course.CourseSaveApplication;
import com.courses.api.application.section.SectionGetApplication;
import com.courses.api.application.sectionclass.SectionClassGetApplication;
import com.courses.api.domain.entity.Course;
import com.courses.api.domain.entity.Section;
import com.courses.api.domain.entity.SectionClass;
import com.courses.api.infrastructure.api.dto.request.CourseRequest;
import com.courses.api.infrastructure.api.dto.request.SectionClassRequest;
import com.courses.api.infrastructure.api.dto.request.SectionRequest;
import com.courses.api.infrastructure.api.dto.response.CourseBasicResponse;
import com.courses.api.infrastructure.api.dto.response.CourseDetailsResponse;
import com.courses.api.infrastructure.api.dto.response.SectionClassResponse;
import com.courses.api.infrastructure.api.dto.response.SectionResponse;
import com.courses.api.infrastructure.api.mapper.course.CourseDetailsResponseMapper;
import com.courses.api.infrastructure.api.mapper.course.CourseRequestMapper;
import com.courses.api.infrastructure.api.mapper.course.CourseResponseMapper;
import com.courses.api.infrastructure.api.mapper.section.SectionRequestMapper;
import com.courses.api.infrastructure.api.mapper.section.SectionResponseMapper;
import com.courses.api.infrastructure.api.mapper.sectionclass.SectionClassRequestMapper;
import com.courses.api.infrastructure.api.mapper.sectionclass.SectionClassResponseMapper;
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
  private final SectionGetApplication sectionGetApplication;
  private final SectionClassGetApplication sectionClassGetApplication;
  private final CourseRequestMapper courseRequestMapper;
  private final CourseResponseMapper courseResponseMapper;
  private final CourseDetailsResponseMapper detailsResponseMapper;
  private final SectionRequestMapper sectionRequestMapper;
  private final SectionClassRequestMapper sectionClassRequestMapper;
  private final SectionResponseMapper sectionResponseMapper;
  private final SectionClassResponseMapper sectionClassResponseMapper;

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

    List<SectionResponse> sectionResponses = sectionResponseMapper
        .toResponse(sectionGetApplication.getAllSectionsByCourseId(id));
    List<SectionClassResponse> classResponses = new ArrayList<>();

    int totalMinutes = 0;
    int totalClasses = 0;

    for (SectionResponse sectionResponse : sectionResponses){
      int minutesCount = 0;
      List<SectionClass> classes = sectionClassGetApplication.getAllBySectionId(sectionResponse.getId());

      for (SectionClass sectionClass : classes) {
        classResponses.add(sectionClassResponseMapper.toResponse(sectionClass));
        minutesCount += sectionClass.getMinutesCount();
      }

      totalMinutes += minutesCount;
      sectionResponse.setMinutesCount(minutesCount);

      totalClasses += classes.size();
    }

    CourseDetailsResponse response = detailsResponseMapper.toResponse(course);
    response.setSkillsToLearnList(Arrays.asList(course.getSkillsToLearn().split(",")));
    response.setRequirementsList(Arrays.asList(course.getRequirements().split(",")));
    response.setCourseIsForList(Arrays.asList(course.getCourseIsFor().split(",")));
    response.setSectionsCount(sectionResponses.size());

    response.setClassesCount(totalClasses);
    response.setMinutesCount(totalMinutes);

    return ResponseEntity.ok(response);
  }


  @PostMapping
  public ResponseEntity<String> saveCourse(@RequestBody CourseRequest request, @RequestHeader("USER_ID") Long id){
    Course course = courseRequestMapper.toEntity(request);
    List<Section> sections = new ArrayList<>();
    List<SectionClass> classes = new ArrayList<>();

    for(SectionRequest sectionRequest : request.getSections()){
      Section section = sectionRequestMapper.toEntity(sectionRequest);
      sections.add(section);

      for (SectionClassRequest sectionClassRequest : sectionRequest.getSectionClasses()){
        SectionClass sectionClass = sectionClassRequestMapper.toEntity(sectionClassRequest);
        classes.add(sectionClass);
      }
    }

    courseSaveApplication.saveCourse(course, sections, classes, id);
    return ResponseEntity.ok("¡El curso fue creado con éxito!");
  }

}
