package com.courses.service.impl;

import com.courses.model.Section;
import com.courses.repository.section.SectionDto;
import com.courses.repository.section.SectionMapper;
import com.courses.repository.section.SectionRepository;
import com.courses.service.CourseService;
import com.courses.service.SectionService;
import com.courses.service.exception.section.SectionDoesNotExistException;
import com.courses.shared.exceptions.ExceptionCode;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SectionServiceImpl implements SectionService {

  private final SectionRepository sectionRepository;
  private final CourseService courseService;
  private final MessageSource messageSource;

  @Override
  public Section saveNewSection(Section section, String courseId) {
    Section savedSection = SectionMapper.INSTANCE.toEntity(
        sectionRepository.save(SectionMapper.INSTANCE.toDto(section)));
    courseService.addCourseSection(savedSection.getId(), courseId);
    return savedSection;
  }

  @Override
  public void deleteSection(String sectionId, String courseId) {
    SectionDto sectionDto = validateExistingSection(sectionId);
    if (!sectionDto.getClassesIds().isEmpty()) {
      courseService.deleteSectionFromCourse(sectionId, courseId);
      sectionRepository.deleteById(sectionId);
    }
  }

  private SectionDto validateExistingSection(String sectionId) {
    Optional<SectionDto> section = sectionRepository.findById(sectionId);

    if (section.isEmpty()) {
      throw new SectionDoesNotExistException(messageSource.getMessage(
          ExceptionCode.SECTION_NOT_FOUND.getType(), null, LocaleContextHolder.getLocale()
      ));
    }

    return section.get();
  }
}
