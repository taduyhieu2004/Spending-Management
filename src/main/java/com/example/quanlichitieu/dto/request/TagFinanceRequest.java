package com.example.quanlichitieu.dto.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@AllArgsConstructor
@NoArgsConstructor
public class TagFinanceRequest {
  @NotBlank(message = "name not blank")
  private String name;
  @NotBlank(message = "description not blank")
  private String description;
  @NotNull(message= "not null")
  private int createdBy;

}
