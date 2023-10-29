package com.courses.api.infrastructure.repository.course;

import com.courses.api.domain.entity.LanguageEnum;
import com.courses.api.infrastructure.repository.user.UserDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "COURSES")
public class CourseDto {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String title;
  @Column(name = "sub_title")
  private String subTitle;
  @Column(name = "main_picture_url")
  private String mainPictureUrl;
  @Column(name = "presentation_video_url")
  private String presentationVideoUrl;
  private Double punctuation;
  @Column(name = "grade_count")
  private Integer gradeCount;
  @Column(name = "students_count")
  private Integer studentsCount;
  @ManyToOne
  @JoinColumn(name = "creator_id")
  private UserDto creator;
  @Enumerated(EnumType.STRING)
  private LanguageEnum language;
  private Double price;
  @Column(name = "skills_to_learn")
  private String skillsToLearn;
  @Column(name = "sections_count")
  private Integer sectionsCount;
  @Column(name = "classes_count")
  private Integer classesCount;
  @Column(name = "minutes_count")
  private Integer minutesCount;
  @Column(name = "created_date")
  private LocalDateTime createdDate;
  @Column(name = "updated_date")
  private LocalDateTime updatedDate;
  private Boolean certification;
  private String requirements;
  private String description;
  @Column(name = "course_is_for")
  private String courseIsFor;
}
