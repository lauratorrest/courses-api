package com.courses.api.domain.entity;

import lombok.Getter;

@Getter
public enum LanguageEnum {
  ENGLISH("ENGLISH"),
  SPANISH("SPANISH");

  private final String language;

  LanguageEnum(String language){this.language = language;}

  public static LanguageEnum getMatchingValueByString(String language) {
    for (LanguageEnum languageEnum : LanguageEnum.values()) {
      if (languageEnum.getLanguage().equals(languageEnum)) {
        return languageEnum;
      }
    }
    return null;
  }
}
