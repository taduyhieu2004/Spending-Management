package com.example.quanlichitieu.exception.transaction;

import com.example.quanlichitieu.exception.base.NotFoundException;

public class TransactionNotFoundException extends NotFoundException {
  public TransactionNotFoundException() {
    setCode("com.example.quanlichitieu.exception.TransactionNotFoundException");
  }

}
