package com.courses.repository.user;

import jakarta.persistence.Id;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document("users")
public class UserDto {

  @Id
  private String id;
  private String name;
  @Indexed(unique = true)
  private String email;
  private String password;
  private String webPageUrl;
  private String linkedInUrl;
  private String youtubeChannelUrl;
  private String facebookUrl;
  private String instagramUrl;
  private String profilePictureUrl;
  private String profession;
  private String aboutMe;
  private LocalDateTime createdDate;
  private LocalDateTime updatedDate;
  private List<String> madeCoursesIds;
  private List<String> boughtCoursesIds;
  private List<String> cartCourses;
}
