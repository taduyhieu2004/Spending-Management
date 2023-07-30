package com.example.quanlichitieu.service.impl;

import com.example.quanlichitieu.dto.response.user.UserResponse;
import com.example.quanlichitieu.entity.User;
import com.example.quanlichitieu.exception.user.UserNotFoundException;
import com.example.quanlichitieu.repository.UserRepository;
import com.example.quanlichitieu.service.UserService;
import com.example.quanlichitieu.ultils.MapperUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
  private final UserRepository repository;

  @Override
  public UserResponse details(int id) {
    log.info("(details) id:{}", id);

    User user = find(id);

    return MapperUtils.toDTO(user, UserResponse.class);
  }

  private User find(int id) {
    log.info("(find) id:{}", id);

    return repository.findById(id).orElseThrow(UserNotFoundException::new);
  }
}
