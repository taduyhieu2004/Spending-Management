package com.example.quanlichitieu.dto.response.transaction;

import com.example.quanlichitieu.dto.response.tagfinance.TagFinanceResponse;
import com.example.quanlichitieu.dto.response.user.UserResponse;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponse {
  private String name;
  private String title;
  private String description;
  private double amount;
  private TagFinanceResponse tagFinance;
  private UserResponse createdBy;
}
