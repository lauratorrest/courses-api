package com.courses.api.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseBasicResponse {

  private String id;
  private String title;
  private String subTitle;
  private String mainPictureUrl;
  private UserBasicResponse user;
}
