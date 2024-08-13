package com.courses.repository.course;

import com.courses.model.Course;
import com.courses.model.Section;
import java.util.List;
import java.util.stream.Collectors;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CourseMapper {

  CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);

  @Mapping(source = "sections", target = "sectionIds", qualifiedByName = "mapSections")
  CourseDto toDto(Course course);

  @Mapping(source = "sectionIds", target = "sections", qualifiedByName = "mapSectionsIds")
  Course toEntity(CourseDto courseDto);

  @Named("mapSections")
  default List<String> mapSections(List<Section> sections) {
    return sections != null
        ? sections.stream().map(Section::getId).collect(Collectors.toList())
        : null;
  }

  @Named("mapSectionsIds")
  default List<Section> mapSectionsIds(List<String> sectionIds) {
    return sectionIds != null
        ? sectionIds.stream().map(id -> Section.builder().id(id).build())
        .collect(Collectors.toList())
        : null;
  }
}
