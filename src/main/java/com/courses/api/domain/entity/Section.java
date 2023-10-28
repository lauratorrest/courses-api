package com.courses.api.domain.entity;

import java.time.Duration;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Section {
  private Long id;
  private Course courseId;
  private String title;
  private Integer classesCount;
  private Duration minutesCount;
}
