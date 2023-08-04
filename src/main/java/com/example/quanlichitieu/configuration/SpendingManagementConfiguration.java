package com.example.quanlichitieu.configuration;


import com.example.quanlichitieu.entity.Transaction;
import com.example.quanlichitieu.facade.AuthenticationFacadeService;
import com.example.quanlichitieu.facade.TagFinanceFacadeService;
import com.example.quanlichitieu.facade.TransactionFacadeService;
import com.example.quanlichitieu.facade.impl.AuthenticationFacadeServiceImpl;
import com.example.quanlichitieu.facade.impl.TagFinanceFacadeServiceImpl;
import com.example.quanlichitieu.facade.impl.TransactionFacadeServiceImpl;
import com.example.quanlichitieu.repository.TagFinanceRepository;
import com.example.quanlichitieu.repository.TransactionRepository;
import com.example.quanlichitieu.repository.UserRepository;
import com.example.quanlichitieu.service.*;
import com.example.quanlichitieu.service.impl.MessageServiceImpl;
import com.example.quanlichitieu.service.impl.TagFinanceServiceImpl;
import com.example.quanlichitieu.service.impl.TransactionServiceImpl;
import com.example.quanlichitieu.service.impl.UserServiceImpl;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SpendingManagementConfiguration {
  @Bean
  public TagFinanceService tagFinanceService(TagFinanceRepository repository) {
    return new TagFinanceServiceImpl(repository);
  }

  @Bean
  public MessageService messageService(MessageSource messageSource) {
    return new MessageServiceImpl(messageSource);
  }

  @Bean
  public UserService userService(UserRepository repository, PasswordEncoder passwordEncoder) {
    return new UserServiceImpl(repository, passwordEncoder);
  }

  @Bean
  public TagFinanceFacadeService tagFinanceFacadeService(
        TagFinanceService tagFinanceService,
        UserService userService
  ) {
    return new TagFinanceFacadeServiceImpl(tagFinanceService, userService);
  }

  @Bean
  public TransactionService transactionService(TransactionRepository repository) {
    return new TransactionServiceImpl(repository);
  }

  @Bean
  public TransactionFacadeService transactionFacadeService(
        TransactionService transactionService,
        TagFinanceService tagFinanceService,
        UserService userService
  ) {
    return new TransactionFacadeServiceImpl(transactionService, tagFinanceService, userService);
  }


}
