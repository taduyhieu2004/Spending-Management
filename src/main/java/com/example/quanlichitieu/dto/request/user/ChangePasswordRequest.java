package com.example.quanlichitieu.dto.request.user;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@AllArgsConstructor
@NoArgsConstructor
public class ChangePasswordRequest {
  @NotBlank
  private String password;
  @NotBlank
  @Size(min = 6)
  private String newPassword;
  @NotBlank
  @Size(min = 6)
  private String confirmPassword;
}
