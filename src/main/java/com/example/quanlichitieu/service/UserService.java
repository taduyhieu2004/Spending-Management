package com.example.quanlichitieu.service;

import com.example.quanlichitieu.dto.response.user.UserResponse;

public interface UserService {
  UserResponse details(int id);
}
