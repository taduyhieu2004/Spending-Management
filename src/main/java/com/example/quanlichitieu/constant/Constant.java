package com.example.quanlichitieu.constant;

public class Constant {
  public static class CommonConstants {
    public static final String SUCCESS = "com.example.quanlichitieu.constant.CommonConstants.SUCCESS";
    public static final String ENCODING_UTF_8 = "UTF-8";
    public static final String LANGUAGE = "Accept-Language";
    public static final String DEFAULT_LANGUAGE = "en";
    public static final String SYSTEM = "SYSTEM";
    public static final Integer EXIST = 1;
    public static final Double DEFAULT_COIN = 0.;
    public static final Integer ACTIVE = 1;
    public static final Integer INACTIVE = 0;
    public static final String ADMIN = "ADMIN";
    public static final String ANONYMOUS = "ANONYMOUS";

  }

  public static class StatusException {
    public static final Integer NOT_FOUND = 404;
    public static final Integer CONFLICT = 409;
    public static final Integer BAD_REQUEST = 400;
    public static final Integer INTERNAL_SERVER_ERROR = 500;
  }
}
