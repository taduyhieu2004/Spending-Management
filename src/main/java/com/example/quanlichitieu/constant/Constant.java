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

  public static class MessageException {
    public static final String CREATE_TAG_FINANCE_SUCCESS = "com.example.quanlichitieu.controller.TagFinanceController.create";
    public static final String UPDATE_TAG_FINANCE_SUCCESS = "com.example.quanlichitieu.controller.TagFinanceController.update";

    public static final String CREATE_TRANSACTION_SUCCESS = "com.example.quanlichitieu.controller.TransactionController.create";
    public static final String UPDATE_TRANSACTION_SUCCESS = "com.example.quanlichitieu.controller.TransactionController.update";
    public static final String CREATE_USER_SUCCESS = "com.example.quanlichitieu.controller.UserController.create";
    public static final String UPDATE_USER_SUCCESS = "com.example.quanlichitieu.controller.UserController.update";
    public static final String CHANGE_PASSWORD_SUCCESS = "com.example.quanlichitieu.controller.UserController.changePassword";

  }

  public static class InvalidMessageException {

    public static final String INVALID_EMAIL = "com.example.quanlichitieu.validation.invalidEmail";

  }

  public static class AuthenticationConstant {
    public static final String CLAIM_USERNAME_KEY = "username";

    public static final String CLAIM_AUTHORITIES_KEY = "authorities";
  }

  public static class AuthConstant {
    public static String TYPE_TOKEN = "Bearer ";
    public static String AUTHORIZATION = "Authorization";
    public static final int AUTHORIZATION_TYPE_SIZE = 7;
    public static final String INVALID_TOKEN = "Token is invalid";
    public static final String EXPIRED_TOKEN = "Token is expired";
  }


}
