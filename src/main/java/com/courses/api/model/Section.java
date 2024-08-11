package com.courses.api.model;

import jakarta.persistence.Id;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document("sections")
public class Section {

  @Id
  private String id;
  private String title;
  private List<String> classesIds;
}
