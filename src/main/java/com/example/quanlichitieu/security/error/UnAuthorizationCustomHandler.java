package com.example.quanlichitieu.security.error;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;

import static com.example.quanlichitieu.ultils.DateUtils.getCurrentDateString;


@Component
public class UnAuthorizationCustomHandler implements AccessDeniedHandler {

  @Override
  public void handle(
      HttpServletRequest request,
      HttpServletResponse response,
      AccessDeniedException accessDeniedException
  ) throws IOException {
    var error = new HashMap<String, Object>();

    error.put("status", 403);
    error.put("timestamp", getCurrentDateString());
    error.put("message", "Forbidden");

    response.sendError(403, new ObjectMapper().writeValueAsString(error));
  }
}
