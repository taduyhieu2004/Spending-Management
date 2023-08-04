package com.example.quanlichitieu.exception.user;

import com.example.quanlichitieu.exception.base.ConflictException;

public class UserNotActivatedException extends ConflictException {
  public UserNotActivatedException() {
    setCode("com.example.quanlichitieu.exception.UserNotActiveException");
  }
}
