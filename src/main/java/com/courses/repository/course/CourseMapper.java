package com.courses.repository.course;

import com.courses.model.Course;
import com.courses.model.Section;
import com.courses.model.User;

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
    @Mapping(source = "creator", target = "creatorId", qualifiedByName = "mapCreatorId")
    CourseDto toDto(Course course);

    @Mapping(source = "sectionIds", target = "sections", qualifiedByName = "mapSectionsIds")
    @Mapping(source = "creatorId", target = "creator", qualifiedByName = "mapCreator")
    Course toEntity(CourseDto courseDto);

    List<Course> toEntity(List<CourseDto> courseDtos);

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

    @Named("mapCreator")
    default User mapCreator(String userId) {
        return userId != null
                ? User.builder().id(userId).build()
                : null;
    }

    @Named("mapCreatorId")
    default String mapCreatorId(User user) {
        return user != null
                ? user.getId()
                : null;
    }
}
