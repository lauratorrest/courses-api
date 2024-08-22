package com.courses.api.dto.response;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SectionResponse {

    private String id;
    private String title;
    private List<ClassBasicResponse> classes;
}
