package com.courses.api.model;

import jakarta.persistence.Id;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "users")
public class User {

  @Id
  private String id;
  private String name;
  private String email;
  private String linkedInUrl;
  private String youtubeChannelUrl;
  private String facebookUrl;
  private String instagramUrl;
  private String profilePictureUrl;
  private String profession;
  private String aboutMe;
  private LocalDateTime createdDate;
  private LocalDateTime updatedDate;
  private List<String> courseIds;
}
