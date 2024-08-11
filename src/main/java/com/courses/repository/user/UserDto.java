package com.courses.repository.user;

import com.courses.repository.course.CourseDto;
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
  private String linkedInUrl;
  private String youtubeChannelUrl;
  private String facebookUrl;
  private String instagramUrl;
  private String profilePictureUrl;
  private String profession;
  private String aboutMe;
  private LocalDateTime createdDate;
  private LocalDateTime updatedDate;
  private List<CourseDto> madeCourses;
  private List<CourseDto> boughtCourses;
  private List<String> cartCourses;
  private Boolean deleted;

  public void onCreate(){
    this.createdDate = LocalDateTime.now();
    this.deleted = Boolean.FALSE;
  }
}
