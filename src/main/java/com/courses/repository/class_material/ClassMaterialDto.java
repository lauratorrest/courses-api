package com.courses.repository.class_material;

import jakarta.persistence.Id;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClassMaterialDto {

  @Id
  private String id;
  private String description;
  private List<String> attachmentsUrls;
  private LocalDateTime createdDate;
  private LocalDateTime updatedDate;
}
