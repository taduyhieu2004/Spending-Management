package com.example.quanlichitieu.configuration;


import com.example.quanlichitieu.repository.TagFinanceRepository;
import com.example.quanlichitieu.service.MessageService;
import com.example.quanlichitieu.service.TagFinanceService;
import com.example.quanlichitieu.service.impl.MessageServiceImpl;
import com.example.quanlichitieu.service.impl.TagFinanceServiceImpl;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpendingManagementConfiguration {
  @Bean
  public TagFinanceService tagFinanceService(TagFinanceRepository tagFinanceRepository) {
    return new TagFinanceServiceImpl(tagFinanceRepository);
  }

  @Bean
  public MessageService messageService(MessageSource messageSource) {
    return new MessageServiceImpl(messageSource);
  }

}
