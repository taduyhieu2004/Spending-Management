package com.example.quanlichitieu.exception.base;


import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Data
public class BaseException extends RuntimeException {
  private String message;
  private String code;
  private int status;
  private Map<String, String> params;

  public BaseException() {
    this.status = 0;
    this.code = "";
    this.message = "";
    this.params = new HashMap<>();
  }

  public void addParam(String key, String value) {
    if (Objects.isNull(params)) {
      params = new HashMap<>();
    }
    params.put(key, value);
  }
}
