package com.example.quanlichitieu.dto.request.authen;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class LoginRequestDTO {
  @NotBlank
  private String username;
  @NotBlank
  @Min(value = 6)
  private String password;
}
