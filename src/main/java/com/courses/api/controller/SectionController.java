package com.courses.api.controller;

import com.courses.api.dto.request.SectionRequest;
import com.courses.api.dto.response.SectionResponse;
import com.courses.api.mapper.request.SectionRequestMapper;
import com.courses.api.mapper.response.SectionResponseMapper;
import com.courses.service.SectionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@Tag(name = "Sections API", description = "End-points for sections management")
@RestController
@RequestMapping("/section")
public class SectionController {

  private final SectionService sectionService;

  @Operation(summary = "Create new section")
  @PostMapping("/create/{courseId}")
  public ResponseEntity<SectionResponse> createNewSection(
      @RequestBody @Valid SectionRequest sectionRequest,
      @PathVariable("courseId") String courseId) {
    return ResponseEntity.ok(SectionResponseMapper.INSTANCE.toResponse(
        sectionService.saveNewSection(SectionRequestMapper.INSTANCE.toEntity(sectionRequest),
            courseId)));
  }

  @Operation(summary = "Delete section")
  @DeleteMapping("/delete/{sectionId}/{courseId}")
  public void deleteSection(@PathVariable("sectionId") String sectionId,
      @PathVariable("courseId") String courseId) {
    sectionService.deleteSection(sectionId, courseId);
  }
}
