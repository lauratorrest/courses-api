package com.courses.api.model;

import jakarta.persistence.Id;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document("classes")
public class Class {

  @Id
  private String id;
  private String title;
  private String videoUrl;
  private Integer secondsCount;
  private Boolean watchedByCurrentUser;
  private List<String> questionsIds;
}
