package com.courses.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig {

  @Value("${cloudinary.cloud_name}")
  private String cloudName;
  @Value("${cloudinary.api_key}")
  private String apiKey;
  @Value("${cloudinary.api_secret_key}")
  private String apiSecretKey;

  @Bean
  public Cloudinary cloudinary() {
    return new Cloudinary(ObjectUtils.asMap(
        "cloud_name", cloudName,
        "api_key", apiKey,
        "api_secret", apiSecretKey
    ));
  }
}
