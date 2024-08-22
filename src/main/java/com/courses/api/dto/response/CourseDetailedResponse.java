package com.courses.api.dto.response;

import com.courses.model.enums.LanguageEnum;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseDetailedResponse {

    private String id;
    private String title;
    private String subTitle;
    private String mainPictureUrl;
    private String presentationVideoUrl;
    private Double punctuation;
    private Integer gradeCount;
    private Integer studentsCount;
    private LanguageEnum language;
    private String category;
    private Double price;
    private Boolean inCurrentUserCart;
    private List<String> skillsToLearn;
    private LocalDateTime createdDate;
    private UserBasicResponse creator;
    private LocalDateTime updatedDate;
    private Boolean certification;
    private List<String> requirements;
    private String description;
    private List<String> courseIsFor;
    private Boolean isPublic;
    private List<SectionResponse> sections;
    private Boolean ratedByCurrentUser;
    private Double currentUserRate;
}
