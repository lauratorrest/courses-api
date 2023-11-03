package com.courses.api.domain.entity;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Purchase {
  private String nonce;
  private BigDecimal amount;
}
