package com.example.quanlichitieu.dto.response.authen;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class LoginResponseDTO {
  private String accessToken;
  private String refreshToken;

  public static LoginResponseDTO from(String accessToken, String refreshToken) {
    var authSignInResponse = new LoginResponseDTO();
    authSignInResponse.accessToken = accessToken;
    authSignInResponse.refreshToken = refreshToken;
    return authSignInResponse;
  }
}
