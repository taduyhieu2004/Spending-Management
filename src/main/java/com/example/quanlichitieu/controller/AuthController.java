package com.example.quanlichitieu.controller;

import com.example.quanlichitieu.dto.ResponseGeneral;
import com.example.quanlichitieu.dto.request.authen.LoginRequestDTO;
import com.example.quanlichitieu.dto.response.authen.LoginResponseDTO;
import com.example.quanlichitieu.facade.AuthenticationFacadeService;
import com.example.quanlichitieu.service.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static com.example.quanlichitieu.constant.Constant.CommonConstants.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("api/v1/auth")
public class AuthController {
  private final AuthenticationFacadeService authenticationFacadeService;
  private final MessageService messageService;

  @PostMapping("login")
  public ResponseGeneral<LoginResponseDTO> login(
        @RequestBody LoginRequestDTO request,
        @RequestHeader(name = LANGUAGE, defaultValue = DEFAULT_LANGUAGE) String language
  ) {
    log.info("(login)  request: {}", request);

    return ResponseGeneral.of(
          HttpStatus.OK.value(),
          messageService.getMessage(SUCCESS, language),
          authenticationFacadeService.login(
                request.getUsername(),
                request.getPassword()
          )
    );
  }

  @PostMapping("logout")
  public ResponseGeneral<Void> logout(
        @RequestHeader(name = LANGUAGE, defaultValue = DEFAULT_LANGUAGE) String language
  ) {

    log.info("(logout)");
    authenticationFacadeService.logout();
    return ResponseGeneral.ofSuccess(
          messageService.getMessage(SUCCESS, language)
    );
  }
}
