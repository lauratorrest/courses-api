package com.courses.shared.exceptions;

import lombok.Getter;

@Getter
public enum ExceptionCode {

  USER_WITH_EMAIL_NOT_FOUND("ERR-001", "Exception.USER_WITH_EMAIL_NOT_FOUND"),
  WRONG_PASSWORD("ERR-002", "Exception.WRONG_PASSWORD"),
  USER_NOT_FOUND("ERR-003", "Exception.USER_NOT_FOUND"),
  FILE_TYPE_NOT_ALLOWED("ERR-004", "Exception.FILE_TYPE_NOT_ALLOWED"),
  FILE_EXCEEDS_ALLOWED_SIZE("ERR-005", "Exception.FILE_EXCEEDS_ALLOWED_SIZE"),
  COURSE_NOT_FOUND("ERR-006", "Exception.COURSE_NOT_FOUND"),
  MAIN_PIC_NEEDED("ERR-007", "Exception.MAIN_PIC_NEEDED"),
  NO_CLASSES_FOUND("ERR-008", "Exception.NO_CLASSES_FOUND"),
  UNCOMPLETED_DATA("ERR-009", "Exception.UNCOMPLETED_DATA"),
  SECTION_NOT_FOUND("ERR-010", "Exception.SECTION_NOT_FOUND"),
  CLASS_NOT_FOUND("ERR-011", "Exception.CLASS_NOT_FOUND"),
  CLASS_VIDEO_NEEDED("ERR-012", "Exception.CLASS_VIDEO_NEEDED"),
  NO_ACTIVE_CLASSES("ERR-013", "Exception.NO_ACTIVE_CLASSES");

  private final String code;
  private final String type;

  ExceptionCode(String code, String type) {
    this.code = code;
    this.type = type;
  }
}
