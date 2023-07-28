package com.example.quanlichitieu.configuration;


import com.example.quanlichitieu.repository.TagFinanceRepository;
import com.example.quanlichitieu.service.TagFinanceService;
import com.example.quanlichitieu.service.impl.TagFinanceServiceImpl;
import org.springframework.context.annotation.Bean;

public class SpendingManagementConfiguration {
  @Bean
  public TagFinanceService tagFinanceService(TagFinanceRepository tagFinanceRepository) {
    return new TagFinanceServiceImpl(tagFinanceRepository);
  }
}
