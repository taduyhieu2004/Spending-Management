package com.example.quanlichitieu.service;

import com.example.quanlichitieu.dto.request.user.UserRequest;
import com.example.quanlichitieu.dto.request.user.UserUpdateRequest;

import com.example.quanlichitieu.dto.response.user.UserPageResponse;
import com.example.quanlichitieu.dto.response.user.UserResponse;

public interface UserService {
  UserResponse create(UserRequest request);

  UserResponse update(UserUpdateRequest request, int id);

  void delete(int id);

  UserResponse details(int id);

  UserPageResponse list(String keyword, int size, int page, boolean isAll);
}
