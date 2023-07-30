package com.example.quanlichitieu.controller;

import com.example.quanlichitieu.dto.ResponseGeneral;
import com.example.quanlichitieu.dto.response.user.UserResponse;
import com.example.quanlichitieu.service.MessageService;
import com.example.quanlichitieu.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import static com.example.quanlichitieu.constant.Constant.CommonConstants.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {
  private final UserService userService;
  private final MessageService messageService;

  @GetMapping("{id}")
  public ResponseGeneral<UserResponse> details(
        @PathVariable int id,
        @RequestHeader(name = LANGUAGE, defaultValue = DEFAULT_LANGUAGE) String language
  ) {

    log.info("(details) id:{}", id);

    return ResponseGeneral.ofSuccess(
          messageService.getMessage(SUCCESS, language),
          userService.details(id)
    );
  }
}
