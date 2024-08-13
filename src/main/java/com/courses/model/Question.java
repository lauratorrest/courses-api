package com.courses.model;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Question {

  private String id;
  private User user;
  private String content;
  private Integer likesAmount;
  private Boolean likedByCurrentUser;
  private LocalDateTime createdDate;
  private LocalDateTime updatedDate;
}
