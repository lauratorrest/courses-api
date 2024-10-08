package com.courses.api.controller;

import com.courses.api.dto.request.CourseDetailedRequest;
import com.courses.api.dto.request.CourseRequest;
import com.courses.api.dto.request.SectionRequest;
import com.courses.api.dto.response.CourseBasicResponse;
import com.courses.api.dto.response.CourseDetailedResponse;
import com.courses.api.dto.response.SectionResponse;
import com.courses.api.mapper.request.CourseRequestMapper;
import com.courses.api.mapper.request.SectionRequestMapper;
import com.courses.api.mapper.response.CourseResponseMapper;
import com.courses.api.mapper.response.SectionResponseMapper;
import com.courses.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@Tag(name = "Courses API", description = "End-points for courses management")
@RestController
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;

    @Operation(summary = "Create a new course with basic information")
    @PostMapping("/create/{userId}")
    public ResponseEntity<CourseBasicResponse> saveCourse(
            @RequestBody @Valid CourseRequest courseRequest, @PathVariable("userId") String userId) {
        return ResponseEntity.ok(CourseResponseMapper.INSTANCE.toResponse(courseService.saveCourse(
                CourseRequestMapper.INSTANCE.toModel(courseRequest), userId)));
    }

    @Operation(summary = "Update course details")
    @PutMapping(value = "/update-info")
    public void updateCourseDetailsInfo(
            @RequestBody @Valid CourseDetailedRequest courseDetailedRequest) {
        courseService.updateCourseDetails(CourseRequestMapper.INSTANCE.toModel(courseDetailedRequest));
    }

    @Operation(summary = "Add course main picture")
    @PostMapping(value = "/set-main-picture/{courseId}", consumes = {
            MediaType.MULTIPART_FORM_DATA_VALUE})
    public void setCourseMainPicture(
            @RequestParam(required = false) MultipartFile mainPicture,
            @PathVariable("courseId") String courseId) {
        courseService.setCourseMainPicture(mainPicture, courseId);
    }

    @Operation(summary = "Add course presentation video")
    @PostMapping(value = "/set-presentation-video/{courseId}", consumes = {
            MediaType.MULTIPART_FORM_DATA_VALUE})
    public void setCoursePresentationVideo(
            @RequestParam(required = false) MultipartFile presentationVideo,
            @PathVariable("courseId") String courseId) {
        courseService.setCoursePresentationVideo(presentationVideo, courseId);
    }

    @Operation(summary = "set course as public/private")
    @PutMapping("/change-privacy-status/{courseId}")
    public void changeCoursePrivacyStatus(@PathVariable("courseId") String courseId) {
        courseService.changeCoursePrivacyStatus(courseId);
    }

    @Operation(summary = "Create new section for course")
    @PostMapping("/{courseId}/add-section")
    public ResponseEntity<SectionResponse> createNewSectionForCourse(
            @RequestBody @Valid SectionRequest sectionRequest,
            @PathVariable("courseId") String courseId) {
        return ResponseEntity.ok(SectionResponseMapper.INSTANCE.toResponse(
                courseService.saveCourseNewSection(SectionRequestMapper.INSTANCE.toEntity(sectionRequest),
                        courseId)));
    }

    //TODO: Get courses with pagination
    //TODO: Get courses filtered
    //TODO: Call user courses (paginated)

    @Operation(summary = "Get course whole information")
    @GetMapping("/{courseId}/{currentUserId}")
    public ResponseEntity<CourseDetailedResponse> getCourseById(
            @PathVariable("currentUserId") String currentUserId,
            @PathVariable("courseId") String courseId) {
        return ResponseEntity.ok(CourseResponseMapper.INSTANCE.toDetailedResponse(
                courseService.findCourseDataById(courseId, currentUserId)));
    }

    @Operation(summary = "Get courses by IDS")
    @GetMapping("/get-all-by-ids")
    public ResponseEntity<List<CourseBasicResponse>> getCourseById(
            @RequestParam("idsList") List<String> idsList) {
        return ResponseEntity.ok(CourseResponseMapper.INSTANCE.toResponse(
                courseService.findAllByIds(idsList)));
    }
}
