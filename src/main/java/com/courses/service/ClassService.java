package com.courses.service;

import com.courses.model.Class;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public interface ClassService {

  Class saveClass(Class entity);

  List<Class> findClassesDataBySectionListIds(List<String> stringStream);

  Class addClassVideo(MultipartFile video, String classId);

  void changeClassStatus(String classId);

  void deleteByIds(List<String> classesIds);
}
