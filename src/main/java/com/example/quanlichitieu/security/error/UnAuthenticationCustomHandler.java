package com.example.quanlichitieu.security.error;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;

import static com.example.quanlichitieu.ultils.DateUtils.getCurrentDateString;


@Component
public class UnAuthenticationCustomHandler implements AuthenticationEntryPoint {
  @Override
  public void commence(
        HttpServletRequest request,
        HttpServletResponse response,
        AuthenticationException authException
  ) throws IOException {
    var error = new HashMap<String, Object>();

    error.put("status", 401);
    error.put("timestamp", getCurrentDateString());
    error.put("message", "UnAuthenticated.");

    response.sendError(401, new ObjectMapper().writeValueAsString(error));
  }
}
