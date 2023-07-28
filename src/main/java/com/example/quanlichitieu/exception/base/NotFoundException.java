package com.example.quanlichitieu.exception.base;


import static com.example.quanlichitieu.constant.Constant.StatusException.NOT_FOUND;

public class NotFoundException extends BaseException {
  public NotFoundException(String id, String objectName) {
    setCode("com.lawman.shop_sport.exception.base.NotFoundException");
    setStatus(NOT_FOUND);
    addParam("id", id);
    addParam("objectName", objectName);
  }
  public NotFoundException(){
    setCode("com.lawman.shop_sport.exception.base.NotFoundException");
    setStatus(NOT_FOUND);
  }
}
