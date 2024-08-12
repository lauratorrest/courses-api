package com.courses.shared.utils;

import java.util.regex.Pattern;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constants {

  public static final Pattern FILE_TYPE_FOR_PICS_ALLOWED = Pattern.compile(
      ".*\\.(jpg|png|jpeg|JPG|PNG|JPEG)");
  public static final Pattern FILE_TYPE_FOR_CLASSES_ALLOWED = Pattern.compile(".*\\.(mp4|MP4)");
  public static final Pattern FILE_TYPE_FOR_CLASSES_ATTACHMENTS = Pattern.compile(
      ".*\\.(jpg|png|jpeg|pdf|docx|pptx|xlsx|JPG|PNG|JPEG|PDF|DOCX|PPTX|XLSX)");
}
