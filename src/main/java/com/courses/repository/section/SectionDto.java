package com.courses.repository.section;

import jakarta.persistence.Id;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("sections")
@Getter
@Setter
public class SectionDto {

  @Id
  private String id;
  private String title;
  private List<String> classesIds;
  private LocalDateTime createdDate;
  private LocalDateTime updatedDate;
  private Boolean isActive;
}
