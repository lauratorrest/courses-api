package com.courses.model;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClassMaterial {

    private String id;
    private String description;
    private List<String> attachmentsUrls;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
