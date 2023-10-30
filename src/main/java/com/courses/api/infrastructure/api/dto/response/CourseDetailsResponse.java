package com.courses.api.infrastructure.api.dto.response;

import com.courses.api.domain.entity.LanguageEnum;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseDetailsResponse {
  private Long id;
  private String title;
  private String subTitle;
  private String mainPictureUrl;
  private String presentationVideoUrl;
  private Double punctuation;
  private Integer gradeCount;
  private Integer studentsCount;
  private String creatorName;
  private LanguageEnum language;
  private Double price;
  private List<String> skillsToLearnList;
  private Integer sectionsCount;
  private Integer classesCount;
  private Integer minutesCount;
  private LocalDateTime createdDate;
  private LocalDateTime updatedDate;
  private Boolean certification;
  private List<String> requirementsList;
  private String description;
  private List<String> courseIsForList;
  private List<SectionResponse> sections;
}
