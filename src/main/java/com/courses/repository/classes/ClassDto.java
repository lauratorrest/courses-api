package com.courses.repository.classes;

import com.courses.repository.class_material.ClassMaterialDto;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document("classes")
public class ClassDto {

  @Id
  private String id;
  private String title;
  private String videoUrl;
  private Integer secondsCount;
  private Boolean watchedByCurrentUser;
  private ClassMaterialDto classMaterial;
  private List<String> questionsIds;
  private LocalDateTime createdDate;
  private LocalDateTime updatedDate;
  private Boolean isActive;
}
