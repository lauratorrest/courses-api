package com.courses.api.infrastructure.api.dto.request;

import com.courses.api.domain.entity.LanguageEnum;
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
  private Integer sectionsCount;
  private Integer classesCount;
  private Integer minutesCount;
  private Boolean certification;
  private String requirements;
  private String description;
  private String courseIsFor;
}
