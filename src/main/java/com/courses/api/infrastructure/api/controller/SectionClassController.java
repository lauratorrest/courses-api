package com.courses.api.infrastructure.api.controller;

import com.courses.api.application.sectionclass.SectionClassGetApplication;
import com.courses.api.domain.entity.SectionClass;
import com.courses.api.infrastructure.api.dto.response.SectionClassResponse;
import com.courses.api.infrastructure.api.mapper.sectionclass.SectionClassResponseMapper;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/classes")
public class SectionClassController {
  private final SectionClassGetApplication sectionClassGetApplication;
  private final SectionClassResponseMapper sectionClassResponseMapper;

  @GetMapping("/{sectionId}")
  public ResponseEntity<List<SectionClassResponse>> getAllClassesBySectionId(@PathVariable("sectionId") Long sectionId){
    List<SectionClass> classes = sectionClassGetApplication.getAllBySectionId(sectionId);

    List<SectionClassResponse> responses = sectionClassResponseMapper.toResponse(classes);

    return ResponseEntity.ok(responses);
  }
}
