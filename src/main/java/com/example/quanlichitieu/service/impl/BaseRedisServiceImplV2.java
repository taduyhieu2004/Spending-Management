package com.example.quanlichitieu.service.impl;

import com.example.quanlichitieu.service.BaseRedisServiceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class BaseRedisServiceImplV2 <K, F, V> implements BaseRedisServiceV2<K, F, V> {

  private final RedisTemplate<K, V> redisTemplate;
  private final HashOperations<K, F, V> hashOperations;

  @Override
  public void set(K key, V value) {
    redisTemplate.opsForValue().set(key, value);
  }

  @Override
  public void setTimeToLive(K key, long timeoutInDays) {
    redisTemplate.expire(key, timeoutInDays, TimeUnit.DAYS);
  }

  @Override
  public void hashSet(K key, F field, V value) {
    hashOperations.put(key, field, value);
  }
}
