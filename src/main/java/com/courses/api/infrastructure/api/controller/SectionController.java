package com.courses.api.infrastructure.api.controller;

import com.courses.api.application.section.SectionGetApplication;
import com.courses.api.application.sectionclass.SectionClassGetApplication;
import com.courses.api.domain.entity.Section;
import com.courses.api.domain.entity.SectionClass;
import com.courses.api.infrastructure.api.dto.response.SectionResponse;
import com.courses.api.infrastructure.api.mapper.section.SectionResponseMapper;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/sections")
public class SectionController {
  private final SectionGetApplication sectionGetApplication;
  private final SectionClassGetApplication sectionClassGetApplication;
  private final SectionResponseMapper sectionResponseMapper;

  @GetMapping("/{courseId}")
  public ResponseEntity<List<SectionResponse>> getAllSectionsByCourseId(@PathVariable("courseId") Long courseId){
    List<Section> sections = sectionGetApplication.getAllSectionsByCourseId(courseId);

    List<SectionResponse> responses = new ArrayList<>();

    for(Section section : sections){
      int minutesCount = 0;
      List<SectionClass> classes = sectionClassGetApplication.getAllBySectionId(section.getId());

      for (SectionClass sectionClass : classes){
        minutesCount = minutesCount + sectionClass.getMinutesCount();
      }

      SectionResponse sectionResponse = sectionResponseMapper.toResponse(section);
      sectionResponse.setMinutesCount(minutesCount);
      responses.add(sectionResponse);
    }

    return ResponseEntity.ok(responses);
  }

}
