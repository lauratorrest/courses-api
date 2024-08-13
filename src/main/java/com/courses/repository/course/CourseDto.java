package com.courses.repository.course;

import com.courses.model.enums.LanguageEnum;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Builder
@Document("courses")
public class CourseDto {

  @Id
  private String id;
  private String title;
  private String subTitle;
  private String mainPictureUrl;
  private String presentationVideoUrl;
  private Double punctuation;
  private Integer gradeCount;
  private Integer studentsCount;
  private LanguageEnum language;
  private String category;
  private Double price;
  private List<String> skillsToLearn;
  private LocalDateTime createdDate;
  private String creatorId;
  private LocalDateTime updatedDate;
  private Boolean certification;
  private List<String> requirements;
  private String description;
  private List<String> courseIsFor;
  private Boolean isPublic;
  private List<String> sectionIds;
  private Boolean ratedByCurrentUser;
  private Double currentUserRate;
}
