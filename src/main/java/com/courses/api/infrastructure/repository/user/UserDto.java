package com.courses.api.infrastructure.repository.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "USERS")
public class UserDto {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String email;
  @Column(name = "linkedin")
  private String linkedInUrl;
  @Column(name = "youtube")
  private String youtubeChannelUrl;
  @Column(name = "facebook")
  private String facebookUrl;
  @Column(name = "instagram")
  private String instagramUrl;
  @Column(name = "profile_pic_url")
  private String profilePictureUrl;
  private String profession;
  @Column(name = "about_me")
  private String aboutMe;
}
