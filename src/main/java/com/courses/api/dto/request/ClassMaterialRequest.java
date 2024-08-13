package com.courses.api.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClassMaterialRequest {

  @Schema(description = "Class material description")
  @Size(max = 100, message = "Description must be between {min} and {max} characters")
  private String description;
}
