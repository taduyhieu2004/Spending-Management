package com.example.quanlichitieu.exception.user;

import com.example.quanlichitieu.exception.base.ConflictException;

public class EmailAlreadyExistException extends ConflictException {
  public EmailAlreadyExistException(){
    setCode("com.example.quanlichitieu.exception.EmailAlreadyExistException");
  }
}
