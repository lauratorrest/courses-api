package com.courses.service.impl;

import com.courses.model.Course;
import com.courses.model.Section;
import com.courses.model.User;
import com.courses.repository.course.CourseDto;
import com.courses.repository.course.CourseMapper;
import com.courses.repository.course.CourseRepository;
import com.courses.service.CloudinaryService;
import com.courses.service.CourseService;
import com.courses.service.SectionService;
import com.courses.service.UserService;
import com.courses.service.exception.course.CourseDoesNotExistException;
import com.courses.service.validation.CourseValidations;
import com.courses.shared.exceptions.ExceptionCode;
import com.courses.shared.utils.Constants;
import com.courses.shared.utils.StringFixProcesses;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final UserService userService;
    private final StringFixProcesses stringFixProcesses;
    private final CloudinaryService cloudinaryService;
    private final MessageSource messageSource;
    private final CourseValidations courseValidations;
    private final SectionService sectionService;

    public Course saveCourse(Course course, String userId) {
        course.setTitle(stringFixProcesses.removeSpaces(course.getTitle()));
        course.setSubTitle(stringFixProcesses.removeSpaces(course.getSubTitle()));
        course.setIsPublic(Boolean.FALSE);
        course.setCreatedDate(LocalDateTime.now());
        course.setPrice(0.0);
        Course savedCourse = CourseMapper.INSTANCE.toEntity(
                courseRepository.save(CourseMapper.INSTANCE.toDto(course)));
        userService.addUserNewCourse(userId, savedCourse.getId());
        return savedCourse;
    }

    @Override
    public void updateCourseDetails(Course course) {
        CourseDto currentCourse = this.validateCourseDoesExists(course.getId());

        currentCourse.setTitle(stringFixProcesses.removeSpaces(course.getTitle()));
        currentCourse.setSubTitle(stringFixProcesses.removeSpaces(course.getSubTitle()));
        currentCourse.setLanguage(course.getLanguage());
        currentCourse.setCategory(course.getCategory());
        currentCourse.setPrice(course.getPrice() != null ? course.getPrice() : 0.0);
        currentCourse.setSkillsToLearn(course.getSkillsToLearn());
        currentCourse.setCertification(
                course.getCertification() != null ? course.getCertification() : Boolean.FALSE);
        currentCourse.setRequirements(course.getRequirements());
        currentCourse.setCourseIsFor(course.getCourseIsFor());
        currentCourse.setUpdatedDate(LocalDateTime.now());
        courseRepository.save(currentCourse);
    }

    @Override
    public void setCourseMainPicture(MultipartFile mainPicture, String courseId) {
        CourseDto currentCourse = this.validateCourseDoesExists(courseId);

        if (mainPicture == null) {
            currentCourse.setMainPictureUrl(null);
        } else {
            String picUrl = cloudinaryService.uploadFile(mainPicture, Constants.PICTURE_FOLDER_NAME,
                    Constants.FILE_TYPE_FOR_PICS_ALLOWED, Constants.PICS_MAX_SIZE);
            currentCourse.setMainPictureUrl(picUrl);
        }

        courseRepository.save(currentCourse);
    }

    @Override
    public void setCoursePresentationVideo(MultipartFile presentationVideo, String courseId) {
        CourseDto currentCourse = this.validateCourseDoesExists(courseId);

        if (presentationVideo == null || presentationVideo.isEmpty()) {
            currentCourse.setPresentationVideoUrl(null);
        } else {
            String picUrl = cloudinaryService.uploadFile(presentationVideo, Constants.VIDEOS_FOLDER_NAME,
                    Constants.FILE_TYPE_FOR_VIDEOS_ALLOWED, Constants.VIDS_MAX_SIZE);
            currentCourse.setPresentationVideoUrl(picUrl);
        }

        courseRepository.save(currentCourse);
    }

    @Override
    public void changeCoursePrivacyStatus(String courseId) {
        Course currentCourse = this.findCourseDataById(courseId, null);

        if (currentCourse.getIsPublic() == Boolean.TRUE) {
            currentCourse.setIsPublic(Boolean.FALSE);
        } else {
            courseValidations.validateCompleteInfo(currentCourse);
            courseValidations.validateAtLeastOneActiveSectionAndClass(currentCourse);
            currentCourse.setIsPublic(Boolean.TRUE);
        }

        courseRepository.save(CourseMapper.INSTANCE.toDto(currentCourse));
    }

    @Override
    public Course findCourseDataById(String courseId, String currentUserId) {
        Course course = CourseMapper.INSTANCE.toEntity(this.validateCourseDoesExists(courseId));
        User creator = userService.getUserById(course.getCreator().getId());
        course.setCreator(creator);
        course.setSections(
                sectionService.findSectionsByIds(course.getSections().stream().map(Section::getId).collect(
                        Collectors.toList())));

        if (Objects.nonNull(currentUserId)) {
            User currentUser = userService.getUserById(currentUserId);
            currentUser.getCartCoursesIds().forEach(id -> {
                if (Objects.equals(id, courseId)) {
                    course.setInCurrentUserCart(Boolean.TRUE);
                }
            });
        }

        return course;
    }

    @Override
    public Section saveCourseNewSection(Section section, String courseId) {
        CourseDto currentCourse = this.validateCourseDoesExists(courseId);
        Section savedSection = sectionService.saveNewSection(section);
        currentCourse.getSectionIds().add(savedSection.getId());
        courseRepository.save(currentCourse);
        return savedSection;
    }

    @Override
    public List<Course> findAllByIds(List<String> coursesIds) {
        return CourseMapper.INSTANCE.toEntity(courseRepository.findAllById(coursesIds));
    }

    private CourseDto validateCourseDoesExists(String courseId) {
        Optional<CourseDto> course = courseRepository.findById(courseId);

        if (course.isEmpty()) {
            throw new CourseDoesNotExistException(messageSource.getMessage(
                    ExceptionCode.COURSE_NOT_FOUND.getType(), null, LocaleContextHolder.getLocale()
            ));
        }

        return course.get();
    }
}
