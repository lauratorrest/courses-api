package com.courses.api.infrastructure.repository.sectionclass;

import com.courses.api.infrastructure.repository.section.SectionDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "SECTION_CLASSES")
public class SectionClassDto {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @ManyToOne
  @JoinColumn(name = "section_id")
  private SectionDto sectionId;
  private String title;
  @Column(name = "minutes_count")
  private Integer minutesCount;
  @Column(name = "video_url")
  private String videoUrl;
}
