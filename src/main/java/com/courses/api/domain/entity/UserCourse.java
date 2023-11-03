package com.courses.api.domain.entity;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserCourse {
  private Long id;
  private User user;
  private Course course;
  private LocalDateTime purchaseDate;
}
