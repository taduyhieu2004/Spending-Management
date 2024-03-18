package com.example.quanlichitieu.facade;

import com.example.quanlichitieu.dto.response.authen.LoginResponseDTO;


public interface AuthenticationFacadeService {
  LoginResponseDTO login(String username, String password);

  void logout();
}
