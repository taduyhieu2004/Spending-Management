package com.example.quanlichitieu.exception.token;


import com.example.quanlichitieu.exception.base.BadRequestException;


public class TokenInvalidException extends BadRequestException {
  public TokenInvalidException() {
    setCode("com.example.quanlichitieu.exception.token.TokenInvalidException");
  }
}
