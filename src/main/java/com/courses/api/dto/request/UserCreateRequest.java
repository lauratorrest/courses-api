package com.courses.api.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateRequest {

  @Schema(description = "User name")
  @NotBlank(message = "User name cannot be blank")
  @Size(min = 5, max = 100, message = "User name must be between {min} and {max} characters")
  @Pattern(regexp = "^[A-Za-zÀ-ÿ\\s]+$", message = "User name can only contain letters and spaces")
  private String name;

  @Schema(description = "User email")
  @NotBlank(message = "User email cannot be blank")
  @Size(max = 100, message = "User email must be {max} characters or less")
  @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$", message = "Invalid email format")
  private String email;

  @Schema(description = "User password")
  @NotBlank(message = "User password cannot be blank")
  @Size(max = 100, message = "User password must be {max} characters or less")
  @Pattern(regexp = "^(?=.*[A-Za-z0-9@#$%^&+=*]).{8,100}$",
      message = "Password must contain letters, numbers and special characters, and be at least 8 characters long")
  private String password;
  @Schema(description = "User LinkedIn profile url")
  private String linkedInUrl;
  @Schema(description = "User Youtube Channel url")
  private String youtubeChannelUrl;
  @Schema(description = "User Facebook profile url")
  private String facebookUrl;
  @Schema(description = "User Instagram profile url")
  private String instagramUrl;
  @Schema(description = "User profile picture url")
  private String profilePictureUrl;
  @Schema(description = "User profile picture url")
  @Size(max = 100,
      message = "User profession must be {max} characters or less")
  @Pattern(regexp = "^[A-Za-zÀ-ÿ\\s]+$", message = "User profession can only contain letters and spaces")
  private String profession;
  @Size(min = 5, max = 100,
      message = "User description must be between {min} and {max} characters")
  private String aboutMe;
}
