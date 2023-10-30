package com.courses.api.application.course;

import com.courses.api.domain.entity.Course;
import com.courses.api.domain.entity.Section;
import com.courses.api.domain.entity.SectionClass;
import com.courses.api.domain.entity.User;
import com.courses.api.domain.service.course.CourseSaveService;
import com.courses.api.domain.service.section.SectionSaveService;
import com.courses.api.domain.service.sectionclass.SectionClassSaveService;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CourseSaveApplication {
  private final CourseSaveService courseSaveService;
  private final SectionSaveService sectionSaveService;
  private final SectionClassSaveService sectionClassSaveService;

  public Course saveCourse(Course course, List<Section> sections, List<SectionClass> classes, Long creatorId){
    try{
      User user = new User();
      user.setId(creatorId);
      course.setCreator(user);
      course.setCreatedDate(LocalDateTime.now());
      course.setUpdatedDate(LocalDateTime.now());
      course.setPunctuation(0.0);
      course.setGradeCount(0);
      course.setStudentsCount(0);
      course.setIsPublic(false);

      Course savedCourse = courseSaveService.saveCourse(course);

      if (sections != null && !sections.isEmpty()) {
        for (Section section : sections) {
          if (section != null) {
            section.setCourseId(savedCourse);
            Section savedSection = sectionSaveService.saveSection(section);
            if (classes != null && !classes.isEmpty()) {
              for (SectionClass sectionClass : classes) {
                if (sectionClass != null) {
                  sectionClass.setSectionId(savedSection);
                  sectionClassSaveService.saveClass(sectionClass);
                }
              }
            }
          }
        }
      }

      return savedCourse;
    }catch (Exception e){
      throw new RuntimeException();
    }
  }
}
