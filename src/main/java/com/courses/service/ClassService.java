package com.courses.service;

import com.courses.model.Class;
import java.util.List;

public interface ClassService {

  Class saveClass(Class entity);

  List<Class> findClassesDataBySectionListIds(List<String> stringStream);
}
