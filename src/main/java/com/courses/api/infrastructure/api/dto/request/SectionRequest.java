package com.courses.api.infrastructure.api.dto.request;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SectionRequest {
  private String title;
  private List<SectionClassRequest> sectionClasses;
}
