package com.example.quanlichitieu.exception.base;


import static com.example.quanlichitieu.constant.Constant.StatusException.BAD_REQUEST;


public class BadRequestException extends BaseException {
  public BadRequestException() {
    setCode("com.lawman.shop_sport.exception.base.BadRequestException");
    setStatus(BAD_REQUEST);
  }
}
