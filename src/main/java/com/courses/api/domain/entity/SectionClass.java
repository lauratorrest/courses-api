package com.courses.api.domain.entity;

import java.time.Duration;
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
  private Duration minutesCount;
  private String videoUrl;
}
