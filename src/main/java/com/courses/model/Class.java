package com.courses.model;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Class {

  private String id;
  private String title;
  private String videoUrl;
  private Integer secondsCount;
  private Boolean watchedByCurrentUser;
  private ClassMaterial classMaterial;
  private List<Question> questions;
  private LocalDateTime createdDate;
  private LocalDateTime updatedDate;
}
