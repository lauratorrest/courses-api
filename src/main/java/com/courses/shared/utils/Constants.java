package com.courses.shared.utils;

import java.util.regex.Pattern;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constants {

    public static final Pattern FILE_TYPE_FOR_PICS_ALLOWED = Pattern.compile(
            ".*\\.(jpg|png|jpeg|JPG|PNG|JPEG)");
    public static final Pattern FILE_TYPE_FOR_VIDEOS_ALLOWED = Pattern.compile(".*\\.(mp4|MP4)");
    public static final Pattern FILE_TYPE_FOR_CLASSES_ATTACHMENTS = Pattern.compile(
            ".*\\.(jpg|png|jpeg|pdf|docx|pptx|xlsx|JPG|PNG|JPEG|PDF|DOCX|PPTX|XLSX)");
    public static final long PICS_MAX_SIZE = 5 * 1024 * 1024;
    public static final long VIDS_MAX_SIZE = PICS_MAX_SIZE * 1000;
    public static final String VIDEOS_FOLDER_NAME = "courses-presentation-videos";
    public static final String PICTURE_FOLDER_NAME = "course-main-pics";
    public static final String PROFILE_PIC_FOLDER_NAME = "profile-pics";
}
