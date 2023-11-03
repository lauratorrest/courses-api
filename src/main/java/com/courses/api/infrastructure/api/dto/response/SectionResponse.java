package com.courses.api.infrastructure.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SectionResponse {
  private Long id;
  private Long courseId;
  private String title;
  private Integer minutesCount;
}
