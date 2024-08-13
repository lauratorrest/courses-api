package com.courses.api.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClassBasicRequest {

  @Schema(description = "Class title")
  @NotBlank(message = "Title must not be empty")
  @Size(min = 5, max = 100, message = "Class title must be between {min} and {max} characters")
  private String title;
}
