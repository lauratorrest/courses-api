package com.courses.api.infrastructure.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SectionClassRequest {
  private String title;
  private String videoUrl;
  private Integer minutesCount;
}
