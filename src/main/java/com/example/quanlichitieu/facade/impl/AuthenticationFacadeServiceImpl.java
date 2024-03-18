package com.example.quanlichitieu.facade.impl;

import com.example.quanlichitieu.dto.response.authen.LoginResponseDTO;
import com.example.quanlichitieu.entity.User;
import com.example.quanlichitieu.exception.user.UserNotActivatedException;
import com.example.quanlichitieu.facade.AuthenticationFacadeService;
import com.example.quanlichitieu.service.JwtTokenService;
import com.example.quanlichitieu.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;


import java.util.HashMap;

import static com.example.quanlichitieu.constant.Constant.AuthenticationConstant.CLAIM_AUTHORITIES_KEY;
import static com.example.quanlichitieu.constant.Constant.AuthenticationConstant.CLAIM_USERNAME_KEY;

@Slf4j
@RequiredArgsConstructor

public class AuthenticationFacadeServiceImpl implements AuthenticationFacadeService {
  private final UserService userService;
  private final JwtTokenService tokenService;

  @Override
  public LoginResponseDTO login(String username, String password) {
    log.info("(login) username: {} , password: {} ", username, password);

    User user = userService.getByUsername(username);
    if (!user.isActive()) {
      throw new UserNotActivatedException();
    }
    userService.equalPassword(password, user.getPassword());

    var claims = new HashMap<String, Object>();
    claims.put(CLAIM_USERNAME_KEY, username);

    final String accessToken = tokenService.generateAccessToken(
          user.getId(), claims);

    final String refreshToken = tokenService.generateRefreshToken(
          user.getId(),
          user.getUsername()
    );
    return new LoginResponseDTO(accessToken, refreshToken);
  }

  @Override
  public void logout() {
    log.info("(logout)");

    SecurityContextHolder.clearContext();

  }
}
