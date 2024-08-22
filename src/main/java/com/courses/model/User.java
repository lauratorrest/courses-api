package com.courses.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

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
    private List<String> madeCoursesIds;
    private List<String> boughtCoursesIds;
    private List<String> cartCoursesIds;
}
