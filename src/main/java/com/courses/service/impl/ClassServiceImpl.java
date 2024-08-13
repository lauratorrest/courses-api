package com.courses.service.impl;

import com.courses.model.Class;
import com.courses.repository.classes.ClassDto;
import com.courses.repository.classes.ClassMapper;
import com.courses.repository.classes.ClassRepository;
import com.courses.service.ClassService;
import com.courses.service.CloudinaryService;
import com.courses.service.exception.classes.ClassDoesNotExistException;
import com.courses.service.exception.classes.ClassWithNoVideoException;
import com.courses.shared.exceptions.ExceptionCode;
import com.courses.shared.utils.Constants;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Service
public class ClassServiceImpl implements ClassService {

  public static final String FOLDER_NAME = "classes-videos";
  private final ClassRepository classRepository;
  private final CloudinaryService cloudinaryService;
  private final MessageSource messageSource;

  @Override
  public Class saveClass(Class classModel) {
    classModel.setCreatedDate(LocalDateTime.now());
    classModel.setIsActive(Boolean.FALSE);
    return ClassMapper.INSTANCE.toEntity(
        classRepository.save(ClassMapper.INSTANCE.toDto(classModel)));
  }

  @Override
  public List<Class> findClassesDataBySectionListIds(List<String> ids) {
    return ClassMapper.INSTANCE.toEntity(classRepository.findAllById(ids));
  }

  @Override
  public Class addClassVideo(MultipartFile video, String classId) {
    ClassDto currentClass = this.validateClassExist(classId);
    String videoUrl = null;

    if (currentClass.getVideoUrl() != null && video == null) {
      currentClass.setUpdatedDate(LocalDateTime.now());
    } else if (video != null) {
      videoUrl = cloudinaryService.uploadFile(video, FOLDER_NAME,
          Constants.FILE_TYPE_FOR_VIDEOS_ALLOWED, Constants.VIDS_MAX_SIZE);
      currentClass.setUpdatedDate(LocalDateTime.now());
    }

    currentClass.setVideoUrl(videoUrl);
    return ClassMapper.INSTANCE.toEntity(classRepository.save(currentClass));
  }

  @Override
  public void changeClassStatus(String classId) {
    ClassDto currentClass = this.validateClassExist(classId);

    if (currentClass.getIsActive() == Boolean.TRUE) {
      currentClass.setIsActive(Boolean.FALSE);
    } else {
      if (currentClass.getVideoUrl() == null) {
        throw new ClassWithNoVideoException(messageSource.getMessage(
            ExceptionCode.CLASS_VIDEO_NEEDED.getType(), null, LocaleContextHolder.getLocale()
        ));
      }
      currentClass.setIsActive(Boolean.TRUE);
    }

    classRepository.save(currentClass);
  }

  @Override
  public void deleteByIds(List<String> classesIds) {
    classRepository.deleteAllById(classesIds);
  }

  private ClassDto validateClassExist(String id) {
    Optional<ClassDto> classDto = classRepository.findById(id);

    if (classDto.isEmpty()) {
      throw new ClassDoesNotExistException(messageSource.getMessage(
          ExceptionCode.CLASS_NOT_FOUND.getType(), null, LocaleContextHolder.getLocale()
      ));
    }

    return classDto.get();
  }
}
