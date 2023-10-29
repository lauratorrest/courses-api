package com.courses.api.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SectionClass {
  private Long id;
  private Section sectionId;
  private String title;
  private Integer minutesCount;
  private String videoUrl;
}
