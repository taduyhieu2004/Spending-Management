package com.example.quanlichitieu.dto.response.authen;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TokenResponseDTO {
  private String accessToken;
  private String refreshToken;
  private Long timeLineAccessToken;


  public static TokenResponseDTO from(
        String accessToken,
        String refreshToken,
        Long timeLineAccessToken
  ) {

    return TokenResponseDTO.builder().
          accessToken(accessToken).
          refreshToken(refreshToken).
          timeLineAccessToken(timeLineAccessToken)
          .build();
  }

}
