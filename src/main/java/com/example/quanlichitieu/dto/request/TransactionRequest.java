package com.example.quanlichitieu.dto.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequest {
  @NotBlank
  private String name;
  @NotBlank
  private String title;
  @NotBlank
  private String description;
  @NotNull
  private double amount;
  @NotNull
  private int tagId;
  @NotNull
  private int createdBy;
}
