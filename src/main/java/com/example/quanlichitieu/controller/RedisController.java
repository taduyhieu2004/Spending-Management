package com.example.quanlichitieu.controller;

import com.example.quanlichitieu.service.BaseRedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/redis")
@RequiredArgsConstructor
public class RedisController {

  private final BaseRedisService redisService;

  @PostMapping
  public void set(){
    redisService.set("hihi","haha");
  }
}
