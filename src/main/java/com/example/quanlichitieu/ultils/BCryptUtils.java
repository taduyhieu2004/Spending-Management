package com.example.quanlichitieu.ultils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class BCryptUtils {
  private BCryptUtils() {
  }

  private static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

  public static PasswordEncoder getPasswordEncoder(){
    return PASSWORD_ENCODER;
  }
}
