package com.example.quanlichitieu.configuration;

import com.example.quanlichitieu.filter.JwtAuthenticationFilter;
import com.example.quanlichitieu.repository.TagFinanceRepository;
import com.example.quanlichitieu.repository.TagFinanceRepositoryTest;
import com.example.quanlichitieu.service.JwtTokenService;
import com.example.quanlichitieu.service.TagFinanceService;
import com.example.quanlichitieu.service.impl.JwtTokenServiceImpl;
import com.example.quanlichitieu.service.impl.TagFinanceServiceImpl;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.sql.DataSource;

@TestConfiguration
@EnableJpaRepositories(
      entityManagerFactoryRef = "testEntityManagerFactory",
      transactionManagerRef = "testTransactionManager")
@ComponentScan(basePackages = {"com.example.quanlichitieu.repository"})
@EnableTransactionManagement
public class Configuration {
  @Bean
  public TagFinanceService tagFinanceService(TagFinanceRepository repository) {
    return new TagFinanceServiceImpl(repository);
  }


 @Bean
 public JwtTokenService jwtTokenService(){
    return new JwtTokenServiceImpl();
 }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http.cors(cors -> cors.configurationSource(corsConfigurationSource()))
          .csrf(AbstractHttpConfigurer::disable)
          .authorizeHttpRequests(
                authorize -> authorize.anyRequest().permitAll()
          )
          .build();
  }

  CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration configuration = new CorsConfiguration();
    configuration.addAllowedHeader("*");
    configuration.addAllowedOrigin("*");
    configuration.addAllowedMethod("*");
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration);
    return source;
  }

  @Bean
  public DataSource dataSource() {

    EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
    return builder.setType(EmbeddedDatabaseType.H2).build();
  }

  @Bean
  public EntityManagerFactory testEntityManagerFactory() {

    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    vendorAdapter.setGenerateDdl(true);

    LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
    factory.setJpaVendorAdapter(vendorAdapter);
    factory.setPackagesToScan("com.example.quanlichitieu.entity");
    factory.setDataSource(dataSource());
    factory.afterPropertiesSet();
    return factory.getObject();
  }

  @Bean
  public PlatformTransactionManager testTransactionManager() {
    JpaTransactionManager txManager = new JpaTransactionManager();
    txManager.setEntityManagerFactory(testEntityManagerFactory());
    return txManager;
  }
}




