package com.courses.model;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Class {

    private String id;
    private String title;
    private String videoUrl;
    private Boolean watchedByCurrentUser;
    private ClassMaterial classMaterial;
    private List<Question> questions;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private Boolean isActive;
}
