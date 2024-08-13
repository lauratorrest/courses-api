package com.courses.repository.section;

import com.courses.model.Class;
import com.courses.model.Section;
import java.util.List;
import java.util.stream.Collectors;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SectionMapper {

  SectionMapper INSTANCE = Mappers.getMapper(SectionMapper.class);

  @Mapping(source = "classesIds", target = "classes", qualifiedByName = "mapClasses")
  Section toEntity(SectionDto sectionDto);

  List<Section> toEntity(List<SectionDto> sectionDto);

  @Mapping(source = "classes", target = "classesIds", qualifiedByName = "mapClassesIds")
  SectionDto toDto(Section section);

  @Named("mapClasses")
  default List<Class> mapClasses(List<String> classesIds) {
    return classesIds != null
        ? classesIds.stream().map(id -> Class.builder().id(id).build()).collect(Collectors.toList())
        : null;
  }

  @Named("mapClassesIds")
  default List<String> mapClassesIds(List<Class> classes) {
    return classes != null
        ? classes.stream().map(Class::getId).collect(Collectors.toList())
        : null;
  }
}
