package com.example.quanlichitieu.exception.user;

import com.example.quanlichitieu.exception.base.NotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;

public class UserNotFoundException extends NotFoundException {
  public UserNotFoundException() {
    setCode("com.example.quanlichitieu.exception.UserNotFoundException");
  }
}
