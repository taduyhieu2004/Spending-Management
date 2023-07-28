package com.example.quanlichitieu.exception.tagfinance;

import com.example.quanlichitieu.exception.base.ConflictException;

public class TagFinanceAlreadyExistException extends ConflictException {
  public TagFinanceAlreadyExistException(){
    setCode("com.example.quanlichitieu.exception.TagFinanceAlreadyExistException");
  }
}
