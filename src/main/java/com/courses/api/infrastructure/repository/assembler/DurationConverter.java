package com.courses.api.infrastructure.repository.assembler;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.time.Duration;

@Converter(autoApply = true)
public class DurationConverter implements AttributeConverter<Duration,String> {


  @Override
  public String convertToDatabaseColumn(Duration attribute) {
    if (attribute == null) {
      return null;
    }

    long hours = attribute.toHours();
    long minutes = attribute.minusHours(hours).toMinutes();
    return String.format("%02d:%02d:00", hours, minutes);
  }

  @Override
  public Duration convertToEntityAttribute(String dbData) {
    if (dbData == null) {
      return null;
    }

    // Convierte el formato de PostgreSQL a Duration
    String[] parts = dbData.split(":");
    long hours = Long.parseLong(parts[0]);
    long minutes = Long.parseLong(parts[1]);
    return Duration.ofHours(hours).plusMinutes(minutes);
  }
}
