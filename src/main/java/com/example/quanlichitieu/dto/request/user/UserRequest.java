package com.example.quanlichitieu.dto.request.user;

import com.example.quanlichitieu.validation.ValidationEmail;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
  @NotBlank
  private String username;
  @NotBlank
  @Size(min = 6)
  private String password;
  @NotBlank
  private String fullName;
  @ValidationEmail
  private String email;

}
