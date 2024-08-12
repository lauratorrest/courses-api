package com.courses.service;

import com.courses.model.Course;
import org.springframework.web.multipart.MultipartFile;

public interface CourseService {

  Course saveCourse(Course course, String userId);

  void updateCourseDetails(Course model);

  void setCourseMainPicture(MultipartFile mainPicture, String courseId);

  void setCoursePresentationVideo(MultipartFile presentationVideo, String courseId);
}
