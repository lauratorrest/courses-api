package com.courses.api.controller;

import com.courses.service.ClassService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@Tag(name = "Classes API", description = "End-points for classes management")
@RestController
@RequestMapping("/class")
public class ClassController {

  private final ClassService classService;

  //@Operation(summary = "Add video to class")
  //@PostMapping(value = "/{classId}/add-video", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  //public ResponseEntity<ClassBasicResponse> addClassVideo(@RequestBody MultipartFile video, @PathVariable("classId") String classId){
  //  return ResponseEntity.ok(ClassResponseMapper.INSTANCE.toResponse(
  //      classService.addClassVideo(video, classId)));
  //}
}
