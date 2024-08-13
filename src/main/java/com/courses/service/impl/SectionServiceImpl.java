package com.courses.service.impl;

import com.courses.model.Class;
import com.courses.model.Section;
import com.courses.repository.section.SectionDto;
import com.courses.repository.section.SectionMapper;
import com.courses.repository.section.SectionRepository;
import com.courses.service.ClassService;
import com.courses.service.SectionService;
import com.courses.service.exception.section.NoActiveClassesException;
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
    section.setIsActive(Boolean.FALSE);
    return SectionMapper.INSTANCE.toEntity(
        sectionRepository.save(SectionMapper.INSTANCE.toDto(section)));
  }

  @Override
  public void deleteSection(String sectionId) {
    SectionDto savedSection = this.validateExistingSection(sectionId);
    if (savedSection.getClassesIds() == null || savedSection.getClassesIds().isEmpty()) {
      sectionRepository.deleteById(sectionId);
    } else {
      classService.deleteByIds(savedSection.getClassesIds());
    }
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
    SectionDto currentSection = this.validateExistingSection(sectionId);
    if (currentSection.getClassesIds() == null) {
      currentSection.setClassesIds(new ArrayList<>());
    }
    currentSection.getClassesIds().add(savedClass.getId());
    sectionRepository.save(currentSection);
    return savedClass;
  }

  @Override
  public void changeSectionStatus(String sectionId) {
    SectionDto currentSection = this.validateExistingSection(sectionId);

    if(currentSection.getIsActive() == Boolean.TRUE){
      currentSection.setIsActive(Boolean.FALSE);
    }else{
      this.validateActiveClass(currentSection);
      currentSection.setIsActive(Boolean.TRUE);
    }

    sectionRepository.save(currentSection);
  }

  private void validateActiveClass(SectionDto currentSection) {
    List<Class> classes = this.setClassesInfo(SectionMapper.INSTANCE.toEntity(currentSection));

    boolean hasActiveClass = classes != null || classes.stream()
        .anyMatch(Class::getIsActive);

    if (!hasActiveClass) {
      throw new NoActiveClassesException(messageSource.getMessage(
          ExceptionCode.NO_ACTIVE_CLASSES.getType(), null, LocaleContextHolder.getLocale()
      ));
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

  private List<Class> setClassesInfo(Section section) {
    if (section.getClasses() != null) {
      List<Class> sectionClasses = classService.findClassesDataBySectionListIds(
          section.getClasses().stream().map(Class::getId).collect(
              Collectors.toList()));
      section.setClasses(sectionClasses);
      return sectionClasses;
    }

    return null;
  }
}
