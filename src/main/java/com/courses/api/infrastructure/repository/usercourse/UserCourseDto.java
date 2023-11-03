package com.courses.api.infrastructure.repository.usercourse;

import com.courses.api.infrastructure.repository.course.CourseDto;
import com.courses.api.infrastructure.repository.user.UserDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "USER_COURSES")
public class UserCourseDto {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @OneToOne
  @JoinColumn(name = "user_id")
  private UserDto user;
  @OneToOne
  @JoinColumn(name = "course_id")
  private CourseDto course;
  @Column(name = "purchase_date")
  private LocalDateTime purchaseDate;
}
