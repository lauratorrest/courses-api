package com.courses.api.controller;

import com.courses.api.dto.request.ClassBasicRequest;
import com.courses.api.dto.response.ClassBasicResponse;
import com.courses.api.mapper.request.ClassRequestMapper;
import com.courses.api.mapper.response.ClassResponseMapper;
import com.courses.service.ClassService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@Tag(name = "Classes API", description = "End-points for classes management")
@RestController
@RequestMapping("/class")
public class ClassController {

  private final ClassService classService;

  @Operation(summary = "Create a new class")
  @PostMapping("/create")
  public ResponseEntity<ClassBasicResponse> createClass(
      @RequestBody @Valid ClassBasicRequest classBasicRequest) {
    return ResponseEntity.ok(ClassResponseMapper.INSTANCE.toResponse(
        classService.saveClass(ClassRequestMapper.INSTANCE.toEntity(classBasicRequest))));
  }
}
