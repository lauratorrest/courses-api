package com.courses.model;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class User {

  private String id;
  private String name;
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
  private List<Course> madeCourses;
  private List<Course> boughtCourses;
  private List<String> cartCourses; //TODO: Cart CRUD
}
