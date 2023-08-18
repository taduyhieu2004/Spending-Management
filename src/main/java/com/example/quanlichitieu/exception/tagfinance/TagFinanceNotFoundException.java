package com.example.quanlichitieu.exception.tagfinance;

import com.example.quanlichitieu.exception.base.NotFoundException;

public class TagFinanceNotFoundException extends NotFoundException {
  public TagFinanceNotFoundException() {
    setCode("com.example.quanlichitieu.exception.TagFinanceNotFoundException");
  }
}
