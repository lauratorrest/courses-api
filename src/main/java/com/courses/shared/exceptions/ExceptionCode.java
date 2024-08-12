package com.courses.shared.exceptions;

import lombok.Getter;

@Getter
public enum ExceptionCode {

  USER_WITH_EMAIL_NOT_FOUND("ERR-001", "Exception.USER_WITH_EMAIL_NOT_FOUND"),
  WRONG_PASSWORD("ERR-002", "Exception.WRONG_PASSWORD"),
  USER_NOT_FOUND("ERR-003", "Exception.USER_NOT_FOUND");

  private final String code;
  private final String type;

  ExceptionCode(String code, String type) {
    this.code = code;
    this.type = type;
  }
}
