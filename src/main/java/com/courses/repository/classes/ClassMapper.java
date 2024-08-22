package com.courses.repository.classes;

import com.courses.model.Class;
import com.courses.model.Question;

import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClassMapper {

    ClassMapper INSTANCE = Mappers.getMapper(ClassMapper.class);

    @Mapping(source = "questionsIds", target = "questions", qualifiedByName = "mapQuestions")
    Class toEntity(ClassDto classDto);

    List<Class> toEntity(List<ClassDto> classDtos);

    @Mapping(source = "questions", target = "questionsIds", qualifiedByName = "mapQuestionsIds")
    ClassDto toDto(Class classModel);

    @Named("mapQuestions")
    default List<Question> mapQuestions(List<String> questionsIds) {
        return questionsIds != null
                ? questionsIds.stream().map(id -> Question.builder().id(id).build())
                .collect(Collectors.toList())
                : null;
    }

    @Named("mapQuestionsIds")
    default List<String> mapQuestionsIds(List<Question> questions) {
        return questions != null
                ? questions.stream().map(Question::getId).collect(Collectors.toList())
                : null;
    }
}
