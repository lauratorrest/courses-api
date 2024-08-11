package com.courses.model;

import jakarta.persistence.Id;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@Setter
@Document("users")
public class User {

  @Id
  private String id;
  private String name;
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
  private List<String> courseIds;
  private Boolean deleted;

  public void onCreate(){
    PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    this.password = passwordEncoder.encode(password);
    this.createdDate = LocalDateTime.now();
    this.deleted = Boolean.FALSE;
  }
}
