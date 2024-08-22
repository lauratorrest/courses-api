package com.courses.api.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserBasicResponse {

    private String id;
    private String name;
    private String email;
    private String profilePictureUrl;
}
