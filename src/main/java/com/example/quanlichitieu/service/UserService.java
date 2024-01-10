package com.example.quanlichitieu.service;

import com.example.quanlichitieu.dto.request.user.ChangePasswordRequest;
import com.example.quanlichitieu.dto.request.user.UserRequest;
import com.example.quanlichitieu.dto.request.user.UserUpdateRequest;

import com.example.quanlichitieu.dto.response.user.UserPageResponse;
import com.example.quanlichitieu.dto.response.user.UserResponse;
import com.example.quanlichitieu.entity.User;

public interface UserService {
  UserResponse create(UserRequest request);

  UserResponse update(UserUpdateRequest request, int id);

  void delete(int id);

  UserResponse details(int id);

  UserPageResponse list(String keyword, int size, int page, boolean isAll);

  void changePassword(int id, ChangePasswordRequest request);

  void active(Integer id);

  void equalPassword(String passwordRaw, String passwordEncrypted);

  User getByUsername(String username);

}
