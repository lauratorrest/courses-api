package com.courses.api.infrastructure.api.dto.request;

import com.courses.api.domain.entity.LanguageEnum;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseRequest {
  private String title;
  private String subTitle;
  private String mainPictureUrl;
  private String presentationVideoUrl;
  private LanguageEnum language;
  private Double price;
  private String skillsToLearn;
  private Boolean certification;
  private String requirements;
  private String description;
  private String courseIsFor;
  private List<SectionRequest> sections;
}
