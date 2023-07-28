package com.example.quanlichitieu.exception.base;


import static com.example.quanlichitieu.constant.Constant.StatusException.INTERNAL_SERVER_ERROR;

public class InternalServerError extends BaseException{
  public InternalServerError() {
    setCode("com.lawman.shop_sport.exception.base.InternalServerError");
    setStatus(INTERNAL_SERVER_ERROR);
  }
}
