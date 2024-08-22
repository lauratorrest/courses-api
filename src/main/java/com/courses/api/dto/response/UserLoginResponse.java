package com.courses.api.dto.response;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserLoginResponse {

    private String id;
    private String name;
    private String email;
    private String profilePictureUrl;
    private List<String> boughtCoursesIds;
    private List<String> cartCoursesIds;
}
