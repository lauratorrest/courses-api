package com.courses.api.model;

import com.courses.api.model.enums.LanguageEnum;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document("courses")
public class Course {

  @Id
  private String id;
  private String title;
  private String subTitle;
  private String mainPictureUrl;
  private String presentationVideoUrl;
  private Double punctuation;
  private Integer gradeCount;
  private Integer studentsCount;
  private String creatorId;
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
  private List<String> sectionIds;
  private Boolean ratedByCurrentUser;
  private Double currentUserRate;
}
