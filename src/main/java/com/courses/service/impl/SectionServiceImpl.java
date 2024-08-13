package com.courses.service.impl;

import com.courses.model.Class;
import com.courses.model.Section;
import com.courses.repository.section.SectionDto;
import com.courses.repository.section.SectionMapper;
import com.courses.repository.section.SectionRepository;
import com.courses.service.ClassService;
import com.courses.service.SectionService;
import com.courses.service.exception.section.SectionDoesNotExistException;
import com.courses.shared.exceptions.ExceptionCode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SectionServiceImpl implements SectionService {

  private final SectionRepository sectionRepository;
  private final MessageSource messageSource;
  private final ClassService classService;

  @Override
  public Section saveNewSection(Section section) {
    section.setCreatedDate(LocalDateTime.now());
    section.setIsActive(Boolean.TRUE);
    return SectionMapper.INSTANCE.toEntity(
        sectionRepository.save(SectionMapper.INSTANCE.toDto(section)));
  }

  @Override
  public void deleteSection(String sectionId, String courseId) {
    SectionDto savedSection = validateExistingSection(sectionId);
    if (savedSection.getClassesIds() == null || savedSection.getClassesIds().isEmpty()) {
      sectionRepository.deleteById(sectionId);
    }

    //TODO:EXCEPTION FOR ACTIVE CLASSES
  }

  @Override
  public List<Section> findSectionsByIds(List<String> ids) {
    List<Section> sections = SectionMapper.INSTANCE.toEntity(sectionRepository.findAllById(ids));
    sections.forEach(this::setClassesInfo);
    return sections;
  }

  @Override
  public Class addNewClassToSection(Class entity, String sectionId) {
    Class savedClass = classService.saveClass(entity);
    SectionDto currentSection = validateExistingSection(sectionId);
    if (currentSection.getClassesIds() == null) {
      currentSection.setClassesIds(new ArrayList<>());
    }
    currentSection.getClassesIds().add(savedClass.getId());
    sectionRepository.save(currentSection);
    return savedClass;
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

  private void setClassesInfo(Section section) {
    if (section.getClasses() != null) {
      List<Class> sectionClasses = classService.findClassesDataBySectionListIds(
          section.getClasses().stream().map(Class::getId).collect(
              Collectors.toList()));
      section.setClasses(sectionClasses);
    }
  }
}
