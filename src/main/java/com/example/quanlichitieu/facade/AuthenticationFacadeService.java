package com.example.quanlichitieu.facade;

import com.example.quanlichitieu.dto.response.authen.LoginResponseDTO;
import jakarta.servlet.http.HttpServletRequest;

public interface AuthenticationFacadeService {
  LoginResponseDTO login(String username, String password);

  void logout();
}
