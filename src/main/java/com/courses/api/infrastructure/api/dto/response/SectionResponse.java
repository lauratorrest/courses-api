package com.courses.api.infrastructure.api.dto.response;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SectionResponse {
  private Long id;
  private String title;
  private Integer minutesCount;
  private List<SectionClassResponse> classes;
}
