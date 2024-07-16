package com.example.quanlichitieu.controller;

import com.example.quanlichitieu.entity.TagFinance;
import com.example.quanlichitieu.service.BaseRedisService;
import com.example.quanlichitieu.service.BaseRedisServiceV2;
import com.ncsgroup.inventory.client.dto.WarehouseRequest;
import com.ncsgroup.inventory.client.dto.product.ProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/redis")
@RequiredArgsConstructor
public class RedisController {

  private final BaseRedisServiceV2<String, String, Integer> redisService;

  @PostMapping
  public String set() {
    redisService.set("redis",1);
    System.out.println(new ProductRequest());
    return "ok";

  }
}
