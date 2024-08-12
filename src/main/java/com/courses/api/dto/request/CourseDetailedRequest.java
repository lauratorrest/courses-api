package com.courses.api.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseDetailedRequest {

  @NotBlank(message = "Id must not be empty")
  @Schema(description = "Unique identifier for the course", example = "12345")
  private String id;
  @Schema(description = "Course title", example = "Introduction to Java Programming")
  @NotBlank(message = "Title must not be empty")
  @Size(min = 5, max = 100, message = "Course title must be between {min} and {max} characters")
  private String title;
  @Schema(description = "Course subtitle", example = "Master the basics of Java")
  @NotBlank(message = "Subtitle must not be empty")
  @Size(min = 5, max = 200, message = "Course subtitle must be between {min} and {max} characters")
  private String subTitle;
  @Schema(description = "Language in which the course is offered", example = "SPANISH")
  private String language;
  @Schema(description = "Course category", example = "Programming")
  private String category;
  @Schema(description = "Course price", example = "99.99")
  private Double price;
  @Schema(description = "Skills that learners will acquire")
  private List<String> skillsToLearn;
  @Schema(description = "Indicates if the course offers certification", example = "true")
  private Boolean certification;
  @Schema(description = "Requirements for taking the course", example = "Basic knowledge of programming")
  private List<String> requirements;
  @Schema(description = "Detailed course description", example = "This course covers the basics of Java programming...")
  private String description;
  @Schema(description = "Audience for whom the course is intended", example = "Beginners in programming")
  private List<String> courseIsFor;
}
