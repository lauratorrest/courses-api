package com.courses.service.validation;

import com.courses.model.Class;
import com.courses.model.Course;
import com.courses.model.Section;
import com.courses.shared.exceptions.exception.course.CourseMainPictureNeededException;
import com.courses.shared.exceptions.exception.course.CourseWithNoClassException;
import com.courses.shared.exceptions.exception.course.CourseWithUncompletedDataException;
import com.courses.shared.exceptions.ExceptionCode;

import java.util.List;
import java.util.Objects;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseValidations {

    private final MessageSource messageSource;

    public void validateCompleteInfo(Course currentCourse) {
        if (currentCourse.getMainPictureUrl() == null) {
            throw new CourseMainPictureNeededException(messageSource.getMessage(
                    ExceptionCode.MAIN_PIC_NEEDED.getType(), null, LocaleContextHolder.getLocale()
            ));
        }

        boolean incompleteData = Objects.isNull(currentCourse.getLanguage()) ||
                Objects.isNull(currentCourse.getCategory()) ||
                isNullOrEmpty(currentCourse.getSkillsToLearn()) ||
                isNullOrEmpty(currentCourse.getRequirements()) ||
                Objects.isNull(currentCourse.getDescription()) ||
                isNullOrEmpty(currentCourse.getCourseIsFor());

        if (incompleteData) {
            throw new CourseWithUncompletedDataException(messageSource.getMessage(
                    ExceptionCode.UNCOMPLETED_DATA.getType(), null, LocaleContextHolder.getLocale()
            ));
        }
    }

    public void validateAtLeastOneActiveSectionAndClass(Course course) {
        if (isNullOrEmpty(course.getSections())) {
            throwNoClassException();
        }

        boolean hasActiveSectionWithActiveClass = course.getSections().stream()
                .filter(Section::getIsActive)
                .anyMatch(section -> !isNullOrEmpty(section.getClasses()) &&
                        section.getClasses().stream().anyMatch(Class::getIsActive));

        if (!hasActiveSectionWithActiveClass) {
            throwNoClassException();
        }
    }

    private void throwNoClassException() {
        throw new CourseWithNoClassException(messageSource.getMessage(
                ExceptionCode.NO_CLASSES_FOUND.getType(), null, LocaleContextHolder.getLocale()
        ));
    }

    private boolean isNullOrEmpty(List<?> list) {
        return list == null || list.isEmpty();
    }
}
