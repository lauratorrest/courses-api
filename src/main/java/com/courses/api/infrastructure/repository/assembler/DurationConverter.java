package com.courses.api.infrastructure.repository.assembler;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.time.Duration;

@Converter(autoApply = true)
public class DurationConverter implements AttributeConverter<Duration,Long> {


  @Override
  public Long convertToDatabaseColumn(Duration attribute) {
    return null;
  }

  @Override
  public Duration convertToEntityAttribute(Long duration) {
    return null;
  }
}
