package com.example.quanlichitieu.dto.response.tagfinance;

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
public class TagFinanceResponse {
  private String name;
  private String description;
  private UserResponse createdBy;

  public TagFinanceResponse(String name, String description, int id, String fullName, String email) {
    this.name = name;
    this.description = description;
    this.createdBy = new UserResponse(id, fullName, email);
  }

  public TagFinanceResponse(String name, String description, int createdBy) {
    this.name = name;
    this.description = description;
    this.createdBy = new UserResponse(createdBy);
  }
}
