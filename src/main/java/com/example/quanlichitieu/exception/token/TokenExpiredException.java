package com.example.quanlichitieu.exception.token;


import com.example.quanlichitieu.exception.base.BadRequestException;

public class TokenExpiredException extends BadRequestException {
    public TokenExpiredException() {
        setCode("com.example.quanlichitieu.exception.token.TokenExpiredException");
    }
}
