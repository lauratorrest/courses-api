package com.courses.api.infrastructure.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserResponse {
  private Long id;
  private String name;
  private String email;
  private String linkedInUrl;
  private String youtubeChannelUrl;
  private String facebookUrl;
  private String instagramUrl;
  private String profilePictureUrl;
  private String profession;
  private String aboutMe;
}
