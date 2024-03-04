package com.example.quanlichitieu.exception.base;


import static com.example.quanlichitieu.constant.Constant.StatusException.CONFLICT;

public class ConflictException extends BaseException {
    public ConflictException(String id, String objectName) {
        setStatus(CONFLICT);
        setCode("com.lawman.shop_sport.exception.base.ConflictException");
        addParam("id", id);
        addParam("objectName", objectName);
    }

    public ConflictException() {
        setStatus(CONFLICT);
        setCode("com.lawman.shop_sport.exception.base.ConflictException");
    }
}