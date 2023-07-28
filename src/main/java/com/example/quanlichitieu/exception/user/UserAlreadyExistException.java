package com.example.quanlichitieu.exception.user;

import com.example.quanlichitieu.exception.base.ConflictException;

public class UserAlreadyExistException extends ConflictException {
  public UserAlreadyExistException() {
    setCode("com.example.quanlichitieu.exception.UserAlreadyExistException");
  }
}
