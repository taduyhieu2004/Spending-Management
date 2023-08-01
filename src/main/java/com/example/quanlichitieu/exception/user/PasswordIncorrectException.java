package com.example.quanlichitieu.exception.user;

import com.example.quanlichitieu.exception.base.ConflictException;

public class PasswordIncorrectException extends ConflictException {
  public PasswordIncorrectException(){
    setCode("com.example.quanlichitieu.exception.PasswordIncorrectException");
  }
}
