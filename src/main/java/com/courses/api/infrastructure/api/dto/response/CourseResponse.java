package com.courses.api.infrastructure.api.dto.response;

import java.time.Duration;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseResponse {
  private Long id;
  private String title;
  private String creatorName;
  private Double punctuation;
  private Integer gradeCount;
  private Double price;
  private LocalDateTime updatedDate;
  private Duration minutesCount;
  private String subTitle;
  private String skillsToLearn;
}
