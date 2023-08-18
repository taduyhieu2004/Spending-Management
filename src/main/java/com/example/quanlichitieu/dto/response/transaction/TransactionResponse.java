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

  public TransactionResponse(String name, String title, String description, double amount,
                             String tagName, String tagDescription, int userTagId,
                             String userTagFullName, String userTagEmail,
                             int userTranId, String userTranFullName, String userTranEmail) {
    this.name = name;
    this.title = title;
    this.description = description;
    this.amount = amount;
    UserResponse userTagResponse = new UserResponse(
          userTagId,
          userTagFullName,
          userTagEmail
    );
    TagFinanceResponse tagFinanceResponse = new TagFinanceResponse(
          tagName,
          tagDescription,
          userTagResponse
    );
    this.tagFinance = tagFinanceResponse;
    UserResponse userResponse = new UserResponse(
          userTranId,
          userTranFullName,
          userTranEmail
    );
    this.createdBy = userResponse;
  }
}
