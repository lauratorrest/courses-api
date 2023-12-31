package com.courses.api.domain.entity;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Course {
  private Long id;
  private String title;
  private String subTitle;
  private String mainPictureUrl;
  private String presentationVideoUrl;
  private Double punctuation;
  private Integer gradeCount;
  private Integer studentsCount;
  private User creator;
  private LanguageEnum language;
  private Double price;
  private String skillsToLearn;
  private LocalDateTime createdDate;
  private LocalDateTime updatedDate;
  private Boolean certification;
  private String requirements;
  private String description;
  private String courseIsFor;
  private Boolean isPublic;
}
