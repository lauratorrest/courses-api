package com.courses.model;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Section {

  private String id;
  private String title;
  private List<Class> classes;
  private LocalDateTime createdDate;
  private LocalDateTime updatedDate;
}
