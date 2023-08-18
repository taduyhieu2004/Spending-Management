package com.example.quanlichitieu.service;

import java.util.Map;

public interface JwtTokenService {
  String generateAccessToken(int userId, Map<String, Object> claims);

  String generateRefreshToken(int userId, String username);

  String getSubjectFromToken(String token);

  Long getExpirationTime(String token);

  String getUsernameFromToken(String token);
}
