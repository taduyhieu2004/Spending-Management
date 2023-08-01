package com.example.quanlichitieu.controller;

import com.example.quanlichitieu.dto.ResponseGeneral;
import com.example.quanlichitieu.dto.request.user.ChangePasswordRequest;
import com.example.quanlichitieu.dto.request.user.UserRequest;
import com.example.quanlichitieu.dto.request.user.UserUpdateRequest;

import com.example.quanlichitieu.dto.response.user.UserPageResponse;
import com.example.quanlichitieu.dto.response.user.UserResponse;
import com.example.quanlichitieu.service.MessageService;
import com.example.quanlichitieu.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import static com.example.quanlichitieu.constant.Constant.CommonConstants.*;
import static com.example.quanlichitieu.constant.Constant.MessageException.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {
  private final UserService userService;
  private final MessageService messageService;


  @PostMapping
  public ResponseGeneral<UserResponse> create(
        @RequestBody @Valid UserRequest request,
        @RequestHeader(name = LANGUAGE, defaultValue = DEFAULT_LANGUAGE) String language
  ) {
    log.info("(create) request: {}", request);

    return ResponseGeneral.ofCreated(
          messageService.getMessage(CREATE_USER_SUCCESS, language),
          userService.create(request)
    );
  }

  @PutMapping("{id}")
  public ResponseGeneral<UserResponse> update(
        @PathVariable int id,
        @RequestBody @Valid UserUpdateRequest request,
        @RequestHeader(name = LANGUAGE, defaultValue = DEFAULT_LANGUAGE) String language
  ) {
    log.info("(update) id: {},request: {} ", id, request);

    return ResponseGeneral.ofSuccess(
          messageService.getMessage(UPDATE_USER_SUCCESS, language),
          userService.update(request, id)
    );
  }

  @DeleteMapping("{id}")
  public ResponseGeneral<Void> delete(
        @PathVariable int id,
        @RequestHeader(name = LANGUAGE, defaultValue = DEFAULT_LANGUAGE) String language
  ) {
    log.info("(delete) id:{}", id);

    userService.delete(id);
    return ResponseGeneral.ofSuccess(
          messageService.getMessage(SUCCESS, language)
    );

  }

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

  @GetMapping
  public ResponseGeneral<UserPageResponse> list(
        @RequestParam(name = "keyword", required = false) String keyword,
        @RequestParam(name = "size", defaultValue = "10") int size,
        @RequestParam(name = "page", defaultValue = "0") int page,
        @RequestParam(name = "all", defaultValue = "false", required = false) boolean isAll,
        @RequestHeader(name = LANGUAGE, defaultValue = DEFAULT_LANGUAGE) String language
  ) {

    log.info("(list) keyword: {}, size: {}, page: {}, isAll: {}", keyword, size, page, isAll);

    return ResponseGeneral.ofSuccess(
          messageService.getMessage(SUCCESS, language),
          userService.list(keyword, size, page, isAll)
    );

  }

  @PostMapping("{id}/change-password")
  public ResponseGeneral<Void> changePassword(
        @PathVariable int id,
        @RequestBody ChangePasswordRequest request,
        @RequestHeader(name = LANGUAGE, defaultValue = DEFAULT_LANGUAGE) String language
  ) {

    log.info("(changePassword) id : {} ,request: {}", id, request);
    userService.changePassword(id, request);

    return ResponseGeneral.ofSuccess(
          messageService.getMessage(CHANGE_PASSWORD_SUCCESS, language)
    );
  }

  @PutMapping("{id}/active")
  public ResponseGeneral<Void> active(
        @PathVariable int id,
        @RequestHeader(name = LANGUAGE, defaultValue = DEFAULT_LANGUAGE) String language
  ) {

    log.info("(active) id : {}", id);
    userService.active(id);

    return ResponseGeneral.ofSuccess(
          messageService.getMessage(SUCCESS, language)
    );
  }
}
