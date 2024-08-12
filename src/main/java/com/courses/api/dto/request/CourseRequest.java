package com.courses.api.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseRequest {

  @Schema(description = "Course title")
  @NotBlank(message = "Title must not be empty")
  @Size(min = 5, max = 100, message = "Course title must be between {min} and {max} characters")
  private String title;
  @Schema(description = "Course subtitle")
  @NotBlank(message = "Subtitle must not be empty")
  @Size(min = 5, max = 200, message = "Course subtitle must be between {min} and {max} characters")
  private String subTitle;
}
