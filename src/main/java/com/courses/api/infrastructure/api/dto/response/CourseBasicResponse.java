package com.courses.api.infrastructure.api.dto.response;

import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseBasicResponse {
  private Long id;
  private String title;
  private String creatorName;
  private Double punctuation;
  private Integer gradeCount;
  private Double price;
  private LocalDateTime updatedDate;
  private Integer minutesCount;
  private String subTitle;
  private List<String> skillsToLearnList;
}
