package com.example.quanlichitieu.configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import static com.example.quanlichitieu.constant.Constant.CommonConstants.ENCODING_UTF_8;


@Configuration
public class MessageConfiguration {
  @Bean
  public MessageSource messageSource() {
    var messageSource = new ReloadableResourceBundleMessageSource();
    messageSource.setBasename("classpath:i18n/messages");
    messageSource.setDefaultEncoding(ENCODING_UTF_8);
    return messageSource;
  }
}
