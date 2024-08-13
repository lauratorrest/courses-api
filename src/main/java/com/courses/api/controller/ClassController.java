package com.courses.api.controller;

import com.courses.api.dto.response.ClassBasicResponse;
import com.courses.api.mapper.response.ClassResponseMapper;
import com.courses.service.ClassService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Tag(name = "Classes API", description = "End-points for classes management")
@RestController
@RequestMapping("/class")
public class ClassController {

  private final ClassService classService;

  @Operation(summary = "Add video to class")
  @PostMapping(value = "/{classId}/add-video", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  public ResponseEntity<ClassBasicResponse> addClassVideo(@RequestBody MultipartFile video, @PathVariable("classId") String classId){
    return ResponseEntity.ok(ClassResponseMapper.INSTANCE.toResponse(
        classService.addClassVideo(video, classId)));
  }

  @Operation(summary = "Activate class")
  @PutMapping("/{classId}/change-status")
  public void changeClassStatus(@PathVariable("classId") String classId){
    classService.changeClassStatus(classId);
  }
}
